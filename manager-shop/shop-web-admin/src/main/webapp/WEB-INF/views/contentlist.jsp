<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!--加载自定义模态框tag-->
<%@ taglib prefix="sys" tagdir="/WEB-INF/tags/sys" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>内容管理</title>
    <jsp:include page="../include/header.jsp"/>
    <link rel="stylesheet" href="/static/assets/plugins/datatables-bs4/css/dataTables.bootstrap4.css">
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
                    <h1 class="m-0 text-dark">内容管理</h1>
                </div>

                <!-- /.col -->
                <div class="col-sm-6">
                    <ol class="breadcrumb float-sm-right">
                        <li class="breadcrumb-item"><a href="/main">Home</a></li>
                        <li class="breadcrumb-item active">Version 3</li>
                    </ol>
                </div><!-- /.col -->
            </div><!-- /.row -->
        </div><!-- /.container-fluid -->
    </div>

    <!-- Form Element sizes -->
    <div class="card card-info card-info-search" style="display:none;">
        <div class="card-header">
            <h3 class="card-title">Advanced Search</h3>
        </div>
        <div class="card-body">
            <div class="row">
                <div class="col-sm-2">
                    <input cssClass="form-control" id="title" name="title" placeholder="Title"/>
                </div>
                <div class="col-2">
                    <input cssClass="form-control" id="subTitle" name="subTitle" placeholder="SubTitle"/>
                </div>
                <div class="col-2">
                    <input cssClass="form-control" id="titleDesc" name="titleDesc" placeholder="TitleDesc"/>
                </div>
                <div class="col-3">
                    <button type="button" class="btn btn-info" onclick="search()">Search</button>
                </div>
            </div>
        </div>
        <!-- /.card-body -->
    </div>
    <!-- /.card -->

    <!-- /.content-header -->
    <div class="row" style="padding-left: 12px;padding-top: 10px; padding-bottom: 15px;">
        <a href="#" type="button" class="btn btn-info btn-sm">insert</a>&nbsp;&nbsp;&nbsp;&nbsp;
        <button type="button" class="btn btn-info btn-sm" onclick="App.deleteMulti('/content/delete');">del</button>&nbsp;&nbsp;&nbsp;&nbsp;
        <a href="#" type="button" class="btn btn-info btn-sm">import</a>&nbsp;&nbsp;&nbsp;&nbsp;
        <button type="button" class="btn btn-info btn-sm">export</button>&nbsp;&nbsp;&nbsp;&nbsp;
        <button type="button" class="btn btn-info btn-sm"
                onclick="$('.card-info-search').css('display') == 'none' ? $('.card-info-search').show('fast') : $('.card-info-search').hide('fast')">
            search
        </button>
    </div>
    <!-- Main content -->
    <section class="content">
        <div class="row">
            <div class="col-12">
                <div class="card">
                    <div class="card-header">
                        <h3 class="card-title">Content Table</h3>
                    </div>
                    <!-- /.card-header -->
                    <div class="card-body">
                        <table id="dataTable" class="display table table-bordered table-hover table-head-fixed">
                            <thead>
                            <tr>
                                <th>
                                    <input type="checkbox" class="minimal icheck_master"/>
                                </th>
                                <th>ID</th>
                                <th>CategoryName</th>
                                <th>Title</th>
                                <th>SubTitle</th>
                                <th>TitleDesc</th>
                                <th>Url</th>
                                <th>Pic</th>
                                <th>Pic2</th>
                                <th>Content</th>
                                <th>Updated</th>
                                <th>Operate</th>
                            </tr>
                            </thead>
                            <tbody>
                            </tbody>
                        </table>
                    </div>
                    <!-- /.card-body -->
                </div>
                <!-- /.card -->
            </div>
            <!-- /.row -->
        </div>
        <!-- /.container-fluid -->
    </section>
    <!-- /.content -->
</div>
<!-- /.content-wrapper -->

<jsp:include page="../include/footer.jsp"/>
<!-- 引入自定义模态框 放在footer.js 需要jQuery,footer 完后jQuery加载进来  -->
<sys:modal/>
<script src="/static/assets/plugins/datatables/jquery.dataTables.js"></script>
<script src="/static/assets/plugins/datatables-bs4/js/dataTables.bootstrap4.js"></script>
<script src="/static/assets/app/dateutil.js"></script>

<script>
    var _dataTable;
    $(function () {
        var _columns = [
            {
                "data": function (row, type, val, meta) {
                    return '<input id="' + row.id + '" type="checkbox" class="minimal" />';
                }
            },
            {data: 'id'},
            {data: 'tbContentCategory.name'},
            {data: 'title'},
            {data: 'subTitle'},
            {data: 'titleDesc'},
            {
                data: function (row, type, val, meta) {
                    if (row.url == null) {
                        return '';
                    }

                    return '<a href="' + row.url + '" target="_blank">查看</a>';
                }
            },
            {
                data: function (row, type, val, meta) {
                    if (row.pic == null) {
                        return '';
                    }

                    return '<a href="' + row.pic + '" target="_blank">查看</a>';
                }
            },
            {
                data: function (row, type, val, meta) {
                    if (row.pic2 == null) {
                        return '';
                    }

                    return '<a href="' + row.pic2 + '" target="_blank">查看</a>';
                }
            },
            {data: 'content'},
            {
                data: function (row, type, val, meta) {
                    return DateOper.getDateByTimeStamp(row.updated);
                }
            },
            {
                data: function (row, type, val, meta) {
                    var detailUrl = "/content/detail?id=" + row.id;
                    var deleteUrl = "/content/delete";
                    return '<button type="button" class="btn btn-sm btn-default" onclick="App.showDetail(\'' + detailUrl + '\');"><i class="fa fa-search"></i> 查看</button>&nbsp;&nbsp;&nbsp;' +
                        '<a href="/content/form?id=' + row.id + '" type="button" class="btn btn-sm btn-primary"><i class="fa fa-edit"></i> 编辑</a>&nbsp;&nbsp;&nbsp;' +
                        '<button type="button" class="btn btn-sm btn-danger" onclick="App.deleteSingle(\'' + deleteUrl + '\', \'' + row.id + '\')"><i class="fa fa-trash-o"></i> 删除</button>';
                }
            }
        ];

        _dataTable = App.initDataTables("/content/page", _columns);

    });

    /**
     * 高级搜索
     */
    function search() {
        var title = $("#title").val();
        var subTitle = $("#subTitle").val();
        var titleDesc = $("#titleDesc").val();

        var param = {
            "title": title,
            "subTitle": subTitle,
            "titleDesc": titleDesc
        };

        _dataTable.settings()[0].ajax.data = param;
        _dataTable.ajax.reload();
    }


</script>
</body>
</html>
