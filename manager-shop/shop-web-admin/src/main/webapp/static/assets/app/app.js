var App = function () {

    // iCheck
    var _masterCheckbox;
    var _checkbox;

    // 用于存放 ID 的数组
    var _idArray;

    // 默认的 Dropzone 参数
    var defaultDropzoneOpts = {
        url: "",
        paramName: "dropFile",
        maxFiles: 1, // 一次性上传的文件数量上限
        maxFilesize: 2, // 文件大小，单位：MB
        acceptedFiles: ".jpg,.gif,.png,.jpeg", // 上传的类型
        addRemoveLinks: true, //默认为false 如果为 true 会给文件添加一个删除链接
        parallelUploads: 1, // 一次上传的文件数量
        dictDefaultMessage: '拖动文件至此或者点击上传',
        dictMaxFilesExceeded: "您最多只能上传 1 个文件！",
        dictResponseError: '文件上传失败!',
        dictInvalidFileType: "文件类型只能是*.jpg,*.gif,*.png,*.jpeg",
        dictFallbackMessage: "浏览器不受支持",
        dictFileTooBig: "文件过大上传文件最大支持",
        dictRemoveLinks: "删除",
        dictCancelUpload: "取消"
    };

    /**
     * 私有方法，初始化 ICheck
     */
    var handlerInitCheckbox = function () {
        // 激活
        $('input[type="checkbox"].minimal, input[type="radio"].minimal').iCheck({
            checkboxClass: 'icheckbox_minimal-blue',
            radioClass: 'iradio_minimal-blue'
        });

        // 获取控制端 Checkbox
        _masterCheckbox = $('input[type="checkbox"].minimal.icheck_master');

        // 获取全部 Checkbox 集合
        _checkbox = $('input[type="checkbox"].minimal');

    };

    /**
     * Checkbox 全选功能
     */
    var handlerCheckboxAll = function () {
        _masterCheckbox.on("ifClicked", function (e) {
            // 返回 true 表示未选中
            if (e.target.checked) {
                _checkbox.iCheck("uncheck");
            }

            // 选中状态
            else {
                _checkbox.iCheck("check");
            }
        });
    };

    /**
     * 删除单笔记录
     * @param url 删除链接
     * @param id 需要删除数据的 ID
     */
    var handlerDeleteSingle = function (url, id, msg) {
        // 可选参数
        if (!msg) msg = null;

        // 将 ID 放入数组中，以便和批量删除通用
        _idArray = new Array();
        _idArray.push(id);

        $("#modal-message").html(msg == null ? "您确定删除数据项吗？" : msg);
        $("#modal-default").modal("show");
        // 绑定删除事件
        $("#btnModalOk").bind("click", function () {
            handlerDeleteData(url);
        });
    };

    /**
     * 批量删除
     */
    var handlerDeleteMulti = function (url) {
        _idArray = new Array();
        //1.获取到复选框
        var _checkBox = App.getCheckBox();
        //2.遍历复选框
        _checkBox.each(function () {
            //当前的复选框的id 属性持有后台数据的 id
            var _id = $(this).attr('id');
            //选中数据 id 放入数组
            if (_id != null && _id != 'undefined' && $(this).is(":checked")) {
                _idArray.push(_id);
            }
        });

        //判断用户是否选择了数据项
        if (_idArray.length === 0) {
            $('#modal-message').html("You have not selected any data");
        }
        else {
            $('#modal-message').html("You are sure to delete this data");
        }

        // 点击删除按钮时弹出模态框
        $('#modal-default').modal('show');

        //无论是否选中数据 , 点击确认按钮
        $('#btnModalOk').bind("click", function () {
            handlerDeleteData(url);
        });

    };

    /**
     * 初始化 DataTables
     * @param url
     * @param columns
     * @returns {*|jQuery}
     */
    var handlerInitDataTables = function (url,columns) {
        var _dataTable = $('#dataTable').DataTable({
            "paging": true,
            "info": true,
            "lengthChange": false,
            "ordering": false,
            "processing": true,
            "searching": false,
            "deferRender": true,

            "aoColumnDefs": [{"bSortable": false, "aTargets": [0]}],//指定某列不排序
            "bLengthChange": true, //开关，是否显示每页显示多少条数据的下拉框
            "aLengthMenu": [[5, 10, 25, -1], [5, 10, 25, "所有"]],//设置每页显示数据条数的下拉选项
            'iDisplayLength': 5, //每页初始显示5条记录
            'bFilter': false,  //是否使用内置的过滤功能（是否去掉搜索框）
            "bInfo": true, //开关，是否显示表格的一些信息(当前显示XX-XX条数据，共XX条)
            "bPaginate": true, //开关，是否显示分页器
            "bSort": false, //是否可排序 
            "serverSide":true,
            "language": {
                "sProcessing": "处理中...",
                "sLengthMenu": "显示 _MENU_ 项结果",
                "sZeroRecords": "没有匹配结果",
                "sInfo": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
                "sInfoEmpty": "显示第 0 至 0 项结果，共 0 项",
                "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
                "sInfoPostFix": "",
                "sSearch": "搜索:",
                "sUrl": "",
                "sEmptyTable": "表中数据为空",
                "sLoadingRecords": "载入中...",
                "sInfoThousands": ",",
                "oPaginate": {
                    "sFirst": "首页",
                    "sPrevious": "上页",
                    "sNext": "下页",
                    "sLast": "末页"
                },
                "oAria": {
                    "sSortAscending": ": 以升序排列此列",
                    "sSortDescending": ": 以降序排列此列"
                }
            },

            "bServerSide": true,

            "ajax": {
                "url": url
            },
            "columns": columns,
            "drawCallback": function( settings ) {
                handlerInitCheckbox();
                handlerCheckboxAll();
            }

        });
        return _dataTable;
    }

    /**
     * AJAX 异步删除
     * @param url
     */
    var handlerDeleteData = function (url) {

        //点击确定后，需要隐藏模态框
        $('#modal-default').modal('hide');

        if (_idArray.length > 0) {

            // AJAX 异步删除操作
            setTimeout(function () {
                $.ajax({
                    "url": url,
                    "type": "POST",
                    "data": {"ids": _idArray.toString()},
                    "dataType": "JSON",
                    "success": function (data) {
                        // 请求成功后，无论是成功或是失败都需要弹出模态框进行提示，所以这里需要先解绑原来的 click 事件
                        $("#btnModalOk").unbind("click");

                        //请求成功
                        if (data.status == 200) {
                            // 确定按钮绑定 ：刷新页面
                            $('#btnModalOk').bind("click", function () {
                                window.location.reload();
                            });

                        }
                        //请求失败
                        else {
                            // 确定按钮绑定 ：隐藏模态框
                            $('#btnModalOk').bind('click', function () {
                                $('#modal-default').modal('hide');
                            });

                        }
                        //因为无论如何都需要提示信息，所以这里的模态框是必须调用的
                        $('#modal-message').html(data.message);
                        $('#modal-default').modal('show');
                    }
                });
            }, 500);

        }

    };

    /**
     * 查看详情
     */
    var handlerShowdetail = function (url) {
        // 这里是通过 Ajax 请求 html 的方式将 jsp 装载进模态框中
        $.ajax({
            url: url,
            type: "get",
            dataType: "html",
            success: function (data) {
                $("#modal-detail-body").html(data);
                $("#modal-detail").modal("show");
            }
        });
    };

    /**
     * 初始化 zTree
     * @param url
     * @param autoParam
     * @param callback
     */
    var handlerInitZTree = function (url, autoParam, callback) {
        var setting = {
            view: {
                selectedMulti: false
            },
            async: {
                enable: true,
                url: url,
                autoParam: autoParam
            }
        };

        $.fn.zTree.init($("#myTree"), setting);

        $("#btnModalOk").bind("click", function () {
            debugger;
            var zTree = $.fn.zTree.getZTreeObj("myTree");
            var nodes = zTree.getSelectedNodes();

            // 未选择
            if (nodes.length == 0) {
                alert("请选择一个节点");
            }
            // 已选择
            else {
                callback(nodes);
            }
        });
    };

    /**
     * 初始化 Dropzone
     * @param opts
     */
    var handlerInitDropzone = function (opts) {
        // 关闭 Dropzone 的自动发现功能
        Dropzone.autoDiscover = false;
        // 继承
        $.extend(defaultDropzoneOpts, opts);
        new Dropzone(defaultDropzoneOpts.id, defaultDropzoneOpts);
    };


    return {
        init: function () {
            handlerInitCheckbox();
            handlerCheckboxAll();
        },
        getCheckBox: function () {
            return _checkbox;
        },
        deleteMulti: function (url) {
            handlerDeleteMulti(url);
        },
        showDetail: function (url) {
            handlerShowdetail(url);
        },
        deleteSingle: function (url, id, msg) {
            handlerDeleteSingle(url, id, msg);
        },
        initDataTables : function (url,columns) {
            return handlerInitDataTables(url,columns);
        },
        /**
         * 初始化 zTree
         * @param url
         * @param autoParam
         * @param callback
         */
        initZTree: function(url, autoParam, callback) {
            handlerInitZTree(url, autoParam, callback);
        },
        /**
         * 初始化 Dropzone
         * @param opts
         */
        initDropzone: function(opts) {
            handlerInitDropzone(opts);
        }
    };

}();

$(document).ready(function () {
    App.init();
});

