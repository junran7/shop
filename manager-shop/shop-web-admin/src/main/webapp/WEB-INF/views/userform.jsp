<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--spring表单标签库-->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title> UserAdd | Back</title>
    <jsp:include page="../include/header.jsp" />
</head>
<body class="hold-transition sidebar-mini">
<div class="wrapper">
    <jsp:include page="../include/nav.jsp" />
</div>

<jsp:include page="../include/menu.jsp" />

<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <div class="content-header">
        <div class="container-fluid">
            <div class="row mb-2">
                <div class="col-sm-6">
                    <h1 class="m-0 text-dark">${tbUsers.id == null ? "Add " : "Edit "}User </h1>
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
                        <h3 class="card-title">User Info</h3>
                    </div>
                    <!-- /.card-header -->
                    <!-- /.card-header -->
                    <!--jstl 获取model中的对象信息-->
                    <c:if test="${baseResult != null}">
                        <div class="card-body">
                            <div class="alert alert-${baseResult.status == 200 ? "success" : "danger" } alert-dismissible">
                                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                                    ${baseResult.message}
                            </div>
                        </div>
                    </c:if>

                    <!-- /.card-body -->

                    <!-- form start -->
                    <!-- spring 表单标签库自动封装实体 commandName/modelAttribute:绑定Model：中的实体名-->
                    <form:form id="inputForm" cssClass="form-horizontal" action="/saveuser" method="post" style="width: 1000px;" modelAttribute="tbUser" >
                        <form:hidden path="id" />
                        <div class="card-body">
                            <div class="form-group row">
                                <label for="email"  class="col-sm-2 col-form-label">Email</label>
                                <div class="col-sm-10">
                                    <form:input cssClass="form-control required" path="email" placeholder="Email" />
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="password"  class="col-sm-2 col-form-label">Password</label>
                                <div class="col-sm-10">
                                    <form:password path="password" cssClass="form-control required" placeholder="Password" />
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="username" class="col-sm-2 col-form-label">Username</label>
                                <div class="col-sm-10">
                                    <form:input path="username" cssClass="form-control required" placeholder="Username" />
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="phone" class="col-sm-2 col-form-label">Phone</label>
                                <div class="col-sm-10">
                                    <form:input path="phone" cssClass="form-control required" placeholder="Phone" />
                                </div>
                            </div>
                            <div class="form-group row">
                                <div class="offset-sm-2 col-sm-10">
                                    <div class="form-check">
                                        <input type="checkbox" class="form-check-input" id="exampleCheck2">
                                        <label class="form-check-label minimal" for="exampleCheck2">Remember me</label>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- /.card-body -->
                        <div class="card-footer">
                            <button type="submit" class="btn btn-info">Sign in</button>
                            <button type="button" class="btn btn-default float-right" onclick="history.go(-1)">Go back</button>
                        </div>
                        <!-- /.card-footer -->
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

<jsp:include page="../include/footer.jsp" />
</body>

<script>
</script>
</html>
