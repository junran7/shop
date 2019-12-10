<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- 模态框放到footer中 , 每个页面都会加载到  -->
<div class="modal fade" id="modal-detail">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">查看详情</h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span></button>
            </div>
            <div class="modal-body">
                <p id="modal-detail-body"></p>
            </div>
            <div class="modal-footer">
                <!-- 查看只需要确定按钮,  data-dismiss 是关闭 modal 属性 -->
                <button type="button" class="btn btn-primary" data-dismiss="modal">确定</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>


<!-- REQUIRED SCRIPTS -->
<!-- jQuery -->
<script src="/static/assets/plugins/jquery/jquery.min.js"></script>
<!-- jQuery validation-->
<script src="/static/assets/plugins/jquery-validation/additional-methods.js"></script>
<script src="/static/assets/plugins/jquery-validation/jquery.validate.js"></script>
<script src="/static/assets/plugins/datatables/jquery.dataTables.js"></script>

<!-- Bootstrap -->
<script src="/static/assets/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- AdminLTE -->
<script src="/static/assets/dist/js/adminlte.js"></script>
<script src="/static/assets/plugins/iCheck/icheck.js"></script>

<!-- OPTIONAL SCRIPTS -->
<script src="/static/assets/dist/js/demo.js"></script>
<script src="/static/assets/dist/js/pages/dashboard3.js"></script>
<!-- App js -->
<script src="/static/assets/app/validate.js"></script>
<script src="/static/assets/app/app.js"></script>