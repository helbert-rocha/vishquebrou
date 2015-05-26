<jsp:include page="header.jsp"/>
<jsp:include page="nav.jsp"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<md-content layout="column" layout-align="center center" class="content-size">
    <div class="app-content">
        
        
        <div class="pane pane-register">
            <div class="form-control-wrapper">
                <form name="registerForm" action="<%= request.getContextPath() %>/register" method="post">
                
			    		<div class="md-toolbar-tools">
			      			<h2 class="md-flex">Cadastro de Operador de Suporte</h2>
			    		</div>
			  		
                    <md-input-container>
                        <label>Usuário</label>
                        <input type="text" ng-required="true" name="username" value="${username ? "" : username}">
	                     <c:if test="${errorUsername == true}">  
	                        <div ng-messages="registerForm.username.$error">
	                            <div ng-message="required">Esse nome de usuário já esta sendo usado.</div>
	                        </div>
	                     </c:if>
                    </md-input-container>
                    
                    <md-input-container>
                        <label>Nome</label>
                        <input type="text" ng-required="true" name="fname" value="${fname ? "" : fname}">
                        
                    </md-input-container>
                    
                    
                    <md-input-container>
                        <label>Sobrenome</label>
                        <input type="text" ng-required="true" name="lname" value="${lname ? "" : lname}">
                        
                    </md-input-container>
					
					<md-input-container>
                        <label>Email</label>
                        <input type="email" ng-required="true" name="email" value="${email ? "" : email}">
	                      <c:if test="${errorEmail == true}">
	                        <div ng-messages="registerForm.email.$error" >
	                            <div ng-message="required">Email já cadastrado.</div>
	                        </div>
	                       </c:if>
                    </md-input-container>
					
					                    
                     <md-input-container>
                        <label>Senha</label>
                        <input type="password" ng-required="true" name="password"">
	                     <c:if test="${errorPswd == true}">   
	                        <div ng-messages="registerForm.password.$error">
	                            <div ng-message="required">Senha não confere.</div>
	                        </div>
	                    </c:if>
                    </md-input-container>
                    
                    <md-input-container>
                        <label>Confirmar Senha</label>
                        <input type="password" ng-required="true" name="confirmPassword" ng-model="user.confirmPassword">
                        <div ng-messages="registerForm.confirmPassword.$error" ng-show="registerForm.confirmPassword.$invalid && registerForm.confirmPassword.$touched">
                            <div ng-message="required">Campo Confirmar Senha deve ser preenchido.</div>
                        </div>
                    </md-input-container>
                    <md-input-container>
                        <label>Nome da Empresa</label>
                        <input type="text" ng-required="true" name="enterprise" value="${enterprise ? "" : enterprise}">
                      
                    </md-input-container>
                    <md-input-container>
                        <label>Ramo da Empresa</label>
                        <input type="text" ng-required="true" name="type" value="${type ? "" : type}">
                    </md-input-container>
    
                    <md-input-container>
                        <label>Estado</label>
                        <input type="text" ng-required="true" name="state" value="${state ? "" : state}">
                    </md-input-container>
                    <md-input-container>
                        <label>Cidade</label>
                        <input type="text" ng-required="true" name="city" value="${city ? "" : city}">
                     
                    </md-input-container>
                    <md-input-container>
                        <label>Bairro</label>
                        <input type="text" ng-required="true" name="district" value="${district ? "" : district}">
                        
                    </md-input-container>
                    <div class="loginBtn">
                        <md-button type="submit" class="md-raised md-primary">Salvar</md-button>
                    </div>
						
                </form>
            </div>
        </div>
    </div>
</md-content>
    

<jsp:include page="footer.jsp"/>