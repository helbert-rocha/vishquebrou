<jsp:include page="header.jsp"/>
<jsp:include page="nav.jsp"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<md-content layout="column" layout-align="center center" class="content-size">
    <div class="app-content">
        
        <div class="pane pane-index">
            <form name="infoForm" method="post" action="<%= request.getContextPath() %>/info">
            	
    				<h1 class="md-toolbar-tools">
      					O que Quebrou?
    				</h1>
                    <md-input-container>
                        <input type="text" ng-required="true" name="what" value="${desc ? "" : desc}">
                         <c:if test="${errorDes == true}"> 
                        <div ng-messages="infoForm.what.$error" >
                            <div ng-message="required">É necessário informar o que quebrou.</div>
                        </div>
                    	</c:if>
                    </md-input-container>
                    
    				<h1 class="md-toolbar-tools">
      					Aonde?
    				</h1>
  					<label>Empresa</label>
                    <md-input-container>
                    
                        <select name="enterprise" ng-required="true"  required>
                         <option class="md-option" value="-1">Selecione uma empresa</option>
						    <c:forEach var="enterprise" items="${enterprises}">
						    <option class="md-option" value="${enterprise.id}">${enterprise.name}-${enterprise.type}-${enterprise.state}-${enterprise.city}-${enterprise.district}</option>
						    </c:forEach>
						  </select>
						  <c:if test="${errorDes == true}">
                        <div ng-messages="infoForm.enterprise.$error">
                            <div ng-message="required">Campo Empresa deve ser preenchido.</div>
                        </div>
                        </c:if>
                    </md-input-container>
                    <label>Nível</label>
                    <md-input-container>
                    
                        <select name="status" ng-required="true">
						    <option  value="Urgente">Urgente</option>
						    <option value="Normal" selected>Normal</option>
						    <option value="Pouca Importância">Pouca Importância</option>
						  </select>
                        <div ng-messages="infoForm.status.$error" ng-show="infoForm.status.$invalid && infoForm.status.$touched">
                            <div ng-message="required">Campo Status deve ser preenchido.</div>
                        </div>
                    </md-input-container>
                    <div class="loginBtn">
                        <md-button type="submit" class="md-raised md-primary">Informar</md-button>
                    </div>
						
                    
                     <div>
                        <a class="md-primary md-button md-default-theme" href="<%= request.getContextPath() %>/login">Sou do Suporte</a>
                    </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</md-content>
<jsp:include page="footer.jsp"/>