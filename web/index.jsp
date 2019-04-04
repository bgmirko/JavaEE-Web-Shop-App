<%-- 
    Document   : index
    Created on : Oct 21, 2012, 1:55:53 PM
    Author     : Mirko
--%>

<%-- Postavi session-scoped varijablu da prati sa koje strane dolazi posetilac. To se koristi zbog mehanizma izbora jezika
     u Controlleru kako bi korisnik ostao na istoj strani kad izabere jezik izmedju Srpskog i Engleskog--%>



<c:set var='view' value='/index' scope='session' />

<script>
  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');

  ga('create', 'UA-48789068-2', 'auto');
  ga('send', 'pageview');

</script>


<div id="indexLeftColumn">
        <script type="text/javascript">
            $(document).ready(function(){
                var height = $("#indexRightColumn").height();
                $("#indexLeftColumn").height(height);   
            });               
        </script>
        <div id="welcomeText">
            <h3 style="text-align: center;">Welcome to the Minilab parts</h3>
            <p><fmt:message key="introText"/></p>
            <p>Browse our parts catalog and happy shopping!</p>        
        </div>
    </div>      
     <div id="indexRightColumn">
        <c:forEach var="grpArtikli" items="${grupeArtikli}">
            <div class="categoryBox">
                <c:url value="/category" var="url">
                    <c:param name="categoryId" value="${grpArtikli.id}"/>
                    <c:param name="strana" value="1"/>             
                </c:url>
                <a href="${url}">
                    <span class="categoryLabel"></span>
                    <span class="categoryLabelText"><fmt:message key="${grpArtikli.naziv}"/></span>
                    <img src="${initParam.productImagePath}zupcanik.png"
                         alt="<fmt:message key="${grpArtikli.naziv}"/>" class="categoryImage">
                </a>
            </div>
        </c:forEach>
    </div>



