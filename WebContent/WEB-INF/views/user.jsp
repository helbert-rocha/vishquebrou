<jsp:include page="header.jsp"/>
<jsp:include page="nav_user.jsp"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/tld/vishquebrou-taglib.tld" prefix="vishquebrou" %>
<div layout="row" layout-align="center start" class="pane-user">
  <md-content class="md-padding user-info">
    <md-tabs md-dynamic-height md-border-bottom>
      <md-tab label="Solicitações">
        <md-content class="md-padding">
          
          <vishquebrou:show className="md-display-2" title="Mensagens">
          </vishquebrou:show> 
          
           <md-content>
			    <section>
			      <md-list layout-padding>
			        <md-list-item class="md-3-line">
			            <div class="md-list-item-text">
			              <c:forEach var="info" items="${infos}">
						    <div layout="column">
							    <p>${ info.description }</p>
							    <div layout="row">
							  
								    <p>${ info.date }</p>
								    <div class="right">
								    	 <p>${ info.status }</p>
								    	
								    </div>
								     
								</div>
								<p>__________________________________________________</p>  
							</div>
							
						</c:forEach>
			            </div>
			        </md-list-item>
			      </md-list>
			    </section>
			    </md-content>
        </md-content>
      </md-tab>
      <md-tab label="Consultar Cadastro">
        <md-content class="md-padding">
        
        <vishquebrou:show className="md-display-2" title="Consultar Cadastro">
          </vishquebrou:show>  		
           
           <label><b>Nome de Usuário</b></label>
          	<p><label>${employee.username}</label></p>
        
           
           	<label><b>Nome</b></label>
          	<p><label>${employee.fname}</label></p>
        
          
         	<label><b>Sobrenome</b></label>
          	<p><label>${employee.lname}</label></p>
         
         	<label><b>Email</b></label>
          	<p><label>${employee.email}</label></p>
          
         	<label><b>Empresa</b></label>
          	<p><label>${employee.enterprise.name}</label></p>
          
          	
       		<label><b>Ramo da Empresa</b></label>
          	<p><label>${employee.enterprise.type}</label></p>
         
         	<label><b>Estado</b></label>
          	<p><label>${employee.enterprise.state}</label></p>
          
			<label><b>Cidade</b></label>
          	<p><label>${employee.enterprise.city}</label></p>
        
          
         	<label><b>Bairro</b></label>
          	<p><label>${employee.enterprise.district}</label></p>
         
       
      </md-tab>
  </md-content>
</div>

<jsp:include page="footer.jsp"/>