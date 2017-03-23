
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <!--
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="hello.htm">Kukimbe Admin</a>
        </div>
-->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand hidden-md" href="hello.htm"><img src="images/kukimbe-logo.png" class=" img-responsive"></a>
        </div>
            <div class="navbar-header pull-right">
                <button type="button" class="navbar-toggle"
                        data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>

                <p class="navbar-text">
                    <a href="logout.htm" class="navbar-link">Logout</a>&nbsp;
                </p>
            </div>
            <div id="navbar" class="collapse navbar-collapse">
                <ul class="nav navbar-nav">
                        <%-- <li class=""><a href="sanity_check.htm">Home</a></li> --%>
                    <li class="${activeNav=='active'?'active':''}"><a href="active.htm">Active</a></li>
                    <li class="${activeNav=='upload'?'active':''}"><a href="uploadPage.htm">Upload Excel</a></li>
                </ul>
            </div>
    </div>
</nav>
