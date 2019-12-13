<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Main Sidebar Container -->
<aside class="main-sidebar sidebar-dark-primary elevation-4">
    <!-- Logo 用户 Logo -->
    <a href="#" class="brand-link">
        <img src="/static/assets/dist/img/AdminLTELogo.png" alt="AdminLTE Logo" class="brand-image img-circle elevation-3"
             style="opacity: .8">
        <span class="brand-text font-weight-light">${user.username}</span>
    </a>

    <!-- 左侧菜单的 email 信息处 -->
    <div class="sidebar">
        <!-- Sidebar user panel (optional) -->
        <div class="user-panel mt-3 pb-3 mb-3 d-flex">
            <div class="image">
                <img src="/static/assets/dist/img/user2-160x160.jpg" class="img-circle elevation-2" alt="User Image">
            </div>
            <div class="info">
                <a href="#" class="d-block">${user.email}</a>
            </div>
        </div>

        <!-- 左侧菜单 Menu -->
        <nav class="mt-2">
            <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
                <!-- Add icons to the links using the .nav-icon class
                     with font-awesome or any other icon font library -->
                <li class="nav-item has-treeview menu-open">
                    <a href="#" class="nav-link active">
                        <%--<i class="nav-icon fas fa-tachometer-alt"></i>--%>
                        <ion-icon name="contacts"></ion-icon>
                        <p>
                            功能列表
                            <i class="right fas fa-angle-left"></i>
                        </p>
                    </a>
                    <ul class="nav nav-treeview">
                        <li class="nav-item has-treeview menu-open">
                            <a href="#" class="nav-link active">
                                <%--<i class="nav-icon fas fa-tachometer-alt"></i>--%>
                                <ion-icon name="contacts"></ion-icon>
                                <p>
                                    用户管理
                                    <i class="right fas fa-angle-left"></i>
                                </p>
                            </a>
                            <ul class="nav nav-treeview">
                                <li class="nav-item">
                                    <a href="/user/list" class="nav-link">
                                        <i class="far fa-circle nav-icon"></i>
                                        <p>用户列表</p>
                                    </a>
                                </li>
                                <li class="nav-item">
                                    <a href="/user/form" class="nav-link">
                                        <i class="far fa-circle nav-icon"></i>
                                        <p>新增用户</p>
                                    </a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                    <ul class="nav nav-treeview">
                        <li class="nav-item has-treeview menu-open">
                            <a href="#" class="nav-link active">
                                <%--<i class="nav-icon fas fa-tachometer-alt"></i>--%>
                                <ion-icon name="contacts"></ion-icon>
                                <p>
                                    内容管理
                                    <i class="right fas fa-angle-left"></i>
                                </p>
                            </a>
                            <ul class="nav nav-treeview">
                                <li class="nav-item">
                                    <a href="/content/list" class="nav-link">
                                        <i class="far fa-circle nav-icon"></i>
                                        <p>内容分类</p>
                                    </a>
                                </li>
                                <li class="nav-item">
                                    <a href="/content/form" class="nav-link">
                                        <i class="far fa-circle nav-icon"></i>
                                        <p>内容列表</p>
                                    </a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                </li>
            </ul>
        </nav>
        <!-- /.sidebar-menu -->
    </div>
    <!-- /.sidebar -->
</aside>