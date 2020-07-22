<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %><html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link rel="stylesheet" href="/webjars/bootstrap/4.4.1-1/css/bootstrap.min.css" />
    <script src="/webjars/jquery/3.4.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.4.1-1/js/bootstrap.min.js"></script>
    <style>
        th{
            text-align: center;
        }
    </style>
</head>

<body>



<div class="container">

    <div class="row">
        <div class="col-sm-3">
            <div class="form-group">
                <label for="exampleFormControlInput1"><spring:message code="header.searh"/> <spring:message code="label.id"/></label>
                <input type="email" class="form-control" id="exampleFormControlInput1" placeholder="12345">
                <br/>
                <button type="button" class="btn btn-primary" id="btnSearch" onclick="ByPresIdByListMap()"><spring:message code="header.searh"/></button>
                &nbsp;&nbsp;<button type="button" class="btn btn-primary" id="add" onclick="AddData()"><spring:message code="header.add"/></button>

            </div>
        </div>

    </div>
    <table class="table table-striped table-hover table-condensed table-bordered">
        <thead>
            <tr>
                <th><spring:message code="header.presname"/></th>
                <th><spring:message code="header.birth_yr"/></th>
                <th><spring:message code="header.party"/></th>
                <th><spring:message code="header.state_born"/></th>
                <th><spring:message code="header.edit"/></th>
                <th><jsp:text></jsp:text></th>
            </tr>
        </thead>
        <tbody id="tbodyPresident">
        <tr>
            <td colspan="6" align="center">data not found</td>
        </tr>
        </tbody>
    </table>
</div>

<br/>
    <div class="modal" tabindex="-1" role="dialog" id="modalAdd">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Add</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form>
                    <div class="form-group row">
                        <label  class="col-sm-3 col-form-label"><b>Pres Name</b></label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" id="presNameInput" >
                        </div>
                    </div>

                    <div class="form-group row">
                        <label class="col-sm-3 col-form-label"><b>Birth Year</b></label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" id="birthYear" >
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-3 col-form-label"><b>Party</b></label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" id="partyInput" >
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-3 col-form-label"><b>State Born</b></label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" id="stateBornInput" >
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" onclick="ajaxToSaveData()">Save changes</button>
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>

<div class="modal" tabindex="-1" role="dialog" id="modalUpdate">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title"><spring:message code="header.edit"/></h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form>
                    <div class="form-group row">
                        <label  class="col-sm-3 col-form-label"><b>Pres Name</b></label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" id="presNameInputUpdate" >
                        </div>
                    </div>

                    <div class="form-group row">
                        <label class="col-sm-3 col-form-label"><b>Birth Year</b></label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" id="birthYearUpdate" >
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-3 col-form-label"><b>Party</b></label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" id="partyInputUpdate" >
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-3 col-form-label"><b>State Born</b></label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" id="stateBornInputUpdate" >
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" onclick="ajaxToUpdateData()">Save changes</button>
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>

<script>
    $(document).ready(function () {
        
    })

    function ByPresIdByListMap() {
        var iputId = $('#exampleFormControlInput1').val()
        var data =  $.ajax({
                type: "GET",
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                headers: {
                    Accept: "application/json"
                },
                url:  '/find=ByPresIdByListMap?presName='+iputId,
                async: false
            }).responseJSON;
        renderDataByListMap(data)
    }

    function renderData(data) {
        var bodyData = $('#tbodyPresident').empty();
        $.each(data,function (index,value) {
            console.log(value.presName)
            bodyData.append('<tr>' +
                                '<td>'+value.presName+'</td>'+
                                '<td>'+value.birthYr+'</td>'+
                                '<td>'+value.party+'</td>'+
                                '<td>'+value.stateBorn+'</td>'+
                                '<td><button type="button" class="btn btn-warning" onclick="updateData(value)">Edit</button></td>'+
                                '<td><button type="button" class="btn btn-warning" onclick="deleteDataById('+value.presId+')">delete</button></td>'+
                             '<tr>');
        })
    }


    function renderDataByListMap(data) {
        var bodyData = $('#tbodyPresident').empty();
        $.each(data,function (index,value) {
            bodyData.append('<tr>' +
                            '<td align="center">'+value.PRESS_NAME+'</td>'+
                            '<td align="center">'+value.BIRTH_YR+'</td>'+
                            '<td align="center">'+value.PRATY+'</td>'+
                            '<td align="center">'+value.STATE_BORN+'</td>'+
                            '<td  align="center"><button type="button" class="btn btn-warning" onclick="updateData('+value+')" style="padding-left: 5px; padding-top: 8px; padding-right: 7px; padding-bottom: 8px; ">Edit</button></td>'+
                            '<td  align="center"><button type="button" class="btn btn-danger" onclick="deleteDataById('+value.PRES_ID+')" style="padding-left: 5px; padding-top: 8px; padding-right: 7px; padding-bottom: 8px;">delete</button></td>'+
                             '<tr>');
        })
    }

    function AddData() {
        $('#modalAdd').modal('show')
    }

    function updateData(data) {
        console.log(data)
        $('#modalUpdate').modal('show')
    }

    function ajaxToUpdateData() {

    }

    function deleteDataById(id) {
        // var data = {
        //     presId : parseInt(id)
        // }
        var data = ["1","2"]
        $.ajax({
            type: "POST",
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            headers: {
                Accept: "application/json"
            },
            url: "/delete",
            data: JSON.stringify(data),
            complete: function (xhr) {
                if (xhr.readyState == 4) {
                    if (xhr.getResponseHeader('statusValidate') == 0) {
                        console.log("Save passs")
                    } else {
                        console.log("Save fail")

                        var msgError = xhr.getResponseHeader('errorMsg');

                    }
                }

            },
            async: false
        });
    }

    function ajaxToSaveData() {

        var $presNameInput= $('#presNameInput').val()
        var $birthYear= $('#birthYear').val()
        var $partyInput= $('#partyInput').val()
        var $stateBornInput= $('#stateBornInput').val()

        var data = {
            presName :$presNameInput,
            birthYr :parseInt($birthYear),
            yrsServ :22,
            deatgAge :33,
            party :$partyInput,
            stateBorn :$stateBornInput,
        }


        $.ajax({
                type: "POST",
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                headers: {
                    Accept: "application/json"
                },
                url: "/saveByJsonObject",
                data: JSON.stringify(data),
                complete: function (xhr) {
                    if (xhr.readyState == 4) {
                        if (xhr.getResponseHeader('statusValidate') == 0) {
                            console.log("Save passs")
                        } else {
                            console.log("Save fail")

                            var msgError = xhr.getResponseHeader('errorMsg');

                        }
                    }

                },
                async: false
            });
    }

    // var data =  $.ajax({
    //     type: "GET",
    //     contentType: "application/json; charset=utf-8",
    //     dataType: "json",
    //     headers: {
    //         Accept: "application/json"
    //     },
    //     url: session.context + '/coGroup/findAllCoGroup',
    //     async: false
    // }).responseJSON;




</script>

</body>

</html>
