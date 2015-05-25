<jsp:include page="header.jsp"/>
<jsp:include page="nav.jsp"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<md-content layout="column" layout-align="center center">
    <div class="app-content">
        
        <div class="pane pane-index">
            <form name="infoForm" method="post" action="<%= request.getContextPath() %>/info">
            	
    				<h1 class="md-toolbar-tools">
      					O que Quebrou?
    				</h1>
                    <md-input-container>
                        <input type="text" ng-required="true" name="what" ng-model="user.what">
                        <div ng-messages="infoForm.what.$error" ng-show="infoForm.what.$invalid && infoForm.what.$touched">
                            <div ng-message="required">É necessário informar o que quebrou.</div>
                        </div>
                    </md-input-container>
                    
    				<h1 class="md-toolbar-tools">
      					Aonde?
    				</h1>
  					
                    <md-input-container>
                        <select name="enterprise" ng-required="true" ng-model="user.enterprise">
						    <c:forEach var="enterprise" items="${enterprises}">
						    <option class="md-option" value="${enterprise.id}">${enterprise.name} ${enterprise.type} ${enterprise.state} ${enterprise.city} ${enterprise.district}</option>
						    </c:forEach>
						  </select>
                        <div ng-messages="infoForm.enterprise.$error" ng-show="infoForm.enterprise.$invalid && infoForm.enterprise.$touched">
                            <div ng-message="required">Campo Empresa deve ser preenchido.</div>
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