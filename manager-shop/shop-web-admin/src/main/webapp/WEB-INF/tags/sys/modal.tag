<!--自定义模态框tag-->
<%@ tag pageEncoding="UTF-8" language="java" %>
<!--是否必填required="true"-->
<%@ attribute name="title" type="java.lang.String" required="false" description="模态框标题" %>
<%@ attribute name="message" type="java.lang.String" required="false" description="模态框消息" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="modal fade" id="modal-default">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">${title == null ? "Warming":title} </h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p id="modal-message">${message}&hellip;</p>
            </div>
            <div class="modal-footer justify-content-between">
                <button type="button" class="btn btn-default" data-dismiss="modal">ClOSE</button>
                <button type="button" class="btn btn-primary" id="btnModalOk">CONFIRM</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>
<!-- /.modal -->

