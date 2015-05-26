<div layout="row" flex >
    <div layout="column" tabindex="-1" role="main" flex>
        <md-toolbar>
            <div class="md-toolbar-tools docs-toolbar-tools md-whiteframe-z3">
                <div layout="row">
                 <img class="logo" src="<%= request.getContextPath() %>/img/vixe-quebrou.png">
                   <a href="<%= request.getContextPath() %>/user"> <h2 class="md-toobar-tools title">
                        Vish Quebrou
                    </h2></a>
                </div>
              
                <div class="exit" layout="column" layout-gt-md="row">
                <jsp:useBean id="name" scope="application" class="br.com.vishquebrou.controller.NameBean">
                </jsp:useBean>
                	<jsp:getProperty property="name" name="name"/>	
                
               <a href="<%= request.getContextPath() %>/logout"> <md-button class="md-icon-button">
                       Sair
              <md-tooltip md-autohide>Sair</md-tooltip>
            </md-button></a>
            </div>
            </div> 
    </md-toolbar>
    </div>
</div>

