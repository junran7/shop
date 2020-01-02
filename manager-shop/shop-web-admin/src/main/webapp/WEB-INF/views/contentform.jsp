<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--spring表单标签库-->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!--加载自定义模态框tag-->
<%@ taglib prefix="sys" tagdir="/WEB-INF/tags/sys" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title> ContentAdd | Back</title>
    <jsp:include page="../include/header.jsp"/>

    <link rel="stylesheet" href="/static/assets/plugins/jquery-ztree/css/zTreeStyle/zTreeStyle.min.css"/>
    <!--拖拽图片上传服务器-->
    <link rel="stylesheet" href="/static/assets/plugins/dropzone/dropzone.css"/>
    <link rel="stylesheet" href="/static/assets/plugins/dropzone/min/basic.min.css"/>

    <link rel="stylesheet" href="/static/assets/plugins/wangEditor/wangEditor.min.css"/>
</head>
<body class="hold-transition sidebar-mini">
<div class="wrapper">
    <jsp:include page="../include/nav.jsp"/>
</div>

<jsp:include page="../include/menu.jsp"/>

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <div class="content-header">
        <div class="container-fluid">
            <div class="row mb-2">
                <div class="col-sm-6">
                    <h1 class="m-0 text-dark">${tbContent.id == null ? "Add " : "Edit "}Content </h1>
                    <small></small>
                </div>

                <!-- /.col -->
                <div class="col-sm-6">
                    <ol class="breadcrumb float-sm-right">
                        <li class="breadcrumb-item"><a href="#">Home</a></li>
                        <li class="breadcrumb-item active">Dashboard v3</li>
                    </ol>
                </div><!-- /.col -->
            </div><!-- /.row -->
        </div><!-- /.container-fluid -->
    </div>
    <!-- /.content-header -->

    <!-- Main content -->
    <div class="content">
        <div class="container-fluid">
            <div class="row">
                <!-- Horizontal Form -->
                <div class="card card-info">
                    <div class="card-header">
                        <h3 class="card-title">Content Info</h3>
                    </div>
                    <!-- /.card-header -->
                    <!-- /.card-header -->
                    <!--jstl 获取model中的对象信息-->
                    <c:if test="${baseResult != null}">
                        <div class="card-body">
                            <div class="alert alert-${baseResult.status == 200 ? "success" : "danger" } alert-dismissible">
                                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;
                                </button>
                                    ${baseResult.message}
                            </div>
                        </div>
                    </c:if>

                    <!-- /.card-body -->

                    <!-- form start -->
                    <!-- spring 表单标签库自动封装实体 commandName/modelAttribute:绑定Model：中的实体名-->
                    <form:form id="inputForm" cssClass="form-horizontal" action="/content/save" method="post"
                               style="width: 1000px;" modelAttribute="tbContent">
                        <form:hidden path="id"/>
                        <div class="card-body">
                            <div class="form-group row">
                                <label class="col-sm-2 control-label">父级类目</label>

                                <div class="col-sm-10">
                                    <form:hidden id="categoryId" path="tbContentCategory.id"/>
                                    <input id="categoryName" class="btn btn-default form-control required"
                                           placeholder="请选择" readonly="true" data-toggle="modal"
                                           data-target="#modal-default" value="${tbContent.tbContentCategory.name}"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="title" class="col-sm-2 control-label">标题</label>

                                <div class="col-sm-10">
                                    <form:input path="title" class="form-control required" placeholder="标题"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="subTitle" class="col-sm-2 control-label">子标题</label>

                                <div class="col-sm-10">
                                    <form:input path="subTitle" class="form-control required" placeholder="子标题"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="titleDesc" class="col-sm-2 control-label">标题描述</label>

                                <div class="col-sm-10">
                                    <form:input path="titleDesc" class="form-control required" placeholder="标题描述"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="url" class="col-sm-2 control-label">链接</label>

                                <div class="col-sm-10">
                                    <form:input path="url" class="form-control" placeholder="链接"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="url" class="col-sm-2 control-label">图片1</label>

                                <div class="col-sm-10">
                                    <form:input path="pic" class="form-control" placeholder="图片1"/>
                                    <div id="dropz" class="dropzone"></div>
                                </div>
                            </div>

                            <div class="form-group">
                                <label for="url" class="col-sm-2 control-label">图片2</label>

                                <div class="col-sm-10">
                                    <form:input path="pic2" class="form-control" placeholder="图片2"/>
                                    <div id="dropz2" class="dropzone"></div>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-2 control-label">详情</label>

                                <div class="col-sm-10">
                                    <form:hidden path="content"/>
                                    <div id="editor">${tbContent.content}</div>
                                </div>
                            </div>
                        </div>

                        <div class="box-footer">
                            <button type="button" class="btn btn-default" onclick="history.go(-1);">返回</button>
                            <button id="btnSubmit" type="submit" class="btn btn-info pull-right">提交</button>
                        </div>
                    </form:form>

                </div>
                <!-- /.card -->
            </div>
            <!-- /.row -->
        </div>
        <!-- /.container-fluid -->
    </div>
    <!-- /.content -->
</div>
<!-- /.content-wrapper -->

<jsp:include page="../include/footer.jsp"/>
</body>

<script src="/static/assets/plugins/jquery-ztree/js/jquery.ztree.core-3.5.min.js"></script>
<script src="/static/assets/plugins/dropzone/min/dropzone.min.js"></script>
<script src="/static/assets/plugins/wangEditor/wangEditor.min.js"></script>

<!-- 自定义模态框 -->
<sys:modal title="请选择" message="<ul id='myTree' class='ztree'></ul>"/>

<script>
    $(function () {

        App.initZTree("/content/category/tree/data", ["id"], function (nodes) {
            debugger;
            var node = nodes[0];
            $("#categoryId").val(node.id);
            $("#categoryName").val(node.name);
            $("#modal-default").modal("hide");
        });

        initWangEditor();
    });

    /**
     * 初始化富文本编辑器
     */
    function initWangEditor() {
        var E = window.wangEditor;
        var editor = new E('#editor');
        // 配置服务器端地址
        editor.customConfig.uploadImgServer = '/upload';
        editor.customConfig.uploadFileName = 'editorFiles';
        editor.create();

        $("#btnSubmit").bind("click", function () {
            var contentHtml = editor.txt.html();
            $("#content").val(contentHtml);
        });
    };

    /**
     * Dropzone 和 jQuery 冲突 所以不能放在 $() 函数中加载
     */
    App.initDropzone({
        id: "#dropz",
        url: "/upload",
        init: function () {
            this.on("success", function (file, data) {
                console.log(file);
                console.log(data);
                debugger
                $("#pic").val(data.fileName);
            });
        }
    });

    App.initDropzone({
        id: "#dropz2",
        url: "/upload",
        init: function () {
            this.on("success", function (file, data) {
                $("#pic2").val(data.fileName);
            });
        }
    });

</script>

</html>
