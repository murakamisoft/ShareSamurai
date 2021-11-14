<div id="wrapper">
    <h1 id="title">利用選択</h1>
    <form:form
        action="${pageContext.request.contextPath}/assets/list"
        method="get" >
        <form:button>シェアできるものを探す</form:button>
    </form:form>

    <form:form
        action="${pageContext.request.contextPath}/assets/create"
        method="get" >
        <form:button>シェアできるものを登録する</form:button>
    </form:form>
</div>
