<#--分页插件-->
<#macro pagaing pageData>
    <div style="text-align: center">
        <div id="datalist">
        </div>
        <script>
            layui.use('laypage', function(){
                var laypage = layui.laypage;
                laypage.render({
                    elem: 'datalist'
                    //总页数
                    ,count: ${pageData.total}
                    //每页条数
                    ,limit: ${pageData.size}
                    //当前页
                    ,curr: ${pageData.current}
                    ,jump: function(obj, first){
                        //首次不执行
                        if(!first){
                            location.href = "?pn=" + obj.curr;
                        }
                    }
                });
            });
        </script>
    </div>


</#macro>