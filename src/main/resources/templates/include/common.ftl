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
<#macro plisting post>

    <li>
        <a href="/user/${post.authorId}" class="fly-avatar">
            <img src="${post.authorAvatar}" alt="${post.authorName}">
        </a>
        <h2>
            <a class="layui-badge">${post.categoryName}</a>
            <a href="/post/${post.id}">${post.title}</a>
        </h2>
        <div class="fly-list-info">
            <a href="/user/${post.authorId}" link>
                <cite>${post.authorName}</cite>
            </a>
            <span>${timeAgo(post.created)}</span>

            <span class="fly-list-nums">
                <i class="iconfont icon-pinglun1" title="回答"></i> ${post.commentCount}
              </span>
        </div>
        <div class="fly-list-badge">
            <#if post.recommend><span class="layui-badge layui-bg-red">精帖</span></#if>
            <#if post.level gt 0><span class="layui-badge layui-bg-black">置顶</span></#if>

        </div>
    </li>
</#macro>