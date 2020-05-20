<#include "include/macro.ftl"/>

<@layout "首页">

<#include "include/header-panel.ftl"/>

<div class="layui-container">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md8">
            <div class="fly-panel">
                <div class="fly-panel-title fly-filter">
                    <a>置顶</a>
                </div>
                <ul class="fly-list">
                    <#list pageData.records as post>
                        <li>
                            <a href="/user/${post.authorId}" class="fly-avatar">
                                <img src="${post.authorAvatar}" alt="${post.authorName}">
                            </a>
                            <h2>
                                <a class="layui-badge">动态</a>
                                <a href="detail/${post.id}">${post.title}</a>
                            </h2>
                            <div class="fly-list-info">
                                <a href="user/${post.authorId}" link>
                                    <cite>${post.authorName}</cite>
                                </a>
                                <span>${timeAgo(post.created)}</span>
                                <span class="fly-list-nums">
                                    <i class="iconfont icon-pinglun1" title="回答"></i> ${post.commentCount}
                                </span>
                            </div>
                            <div class="fly-list-badge">
                                 <#if post.recommend> <span class="layui-badge layui-bg-black">置顶</span></#if>
                                 <#if post.level gt 0> <span class="layui-badge layui-bg-red">精帖</span></#if>
                            </div>
                        </li>
                    </#list>
                </ul>
            </div>

            <div class="fly-panel" style="margin-bottom: 0;">

                <div class="fly-panel-title fly-filter">
                    <a href="" class="layui-this">综合</a>
                    <span class="fly-mid"></span>
                    <a href="">未结</a>
                    <span class="fly-mid"></span>
                    <a href="">已结</a>
                    <span class="fly-mid"></span>
                    <a href="">精华</a>
                    <span class="fly-filter-right layui-hide-xs">
            <a href="" class="layui-this">按最新</a>
            <span class="fly-mid"></span>
            <a href="">按热议</a>
          </span>
                </div>

                <ul class="fly-list">
                    <#list pageData.records as post>
                        <li>
                            <a href="/user/${post.authorId}" class="fly-avatar">
                                <img src="${post.authorAvatar}" alt=${post.authorName}>
                            </a>
                            <h2>
                                <a class="layui-badge">${post.categoryName}</a>
                                <a href="/detail/${post.categoryId}">${post.title}</a>
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
                        </li>
                    </#list>
                </ul>
                <#--分页-->
                <@pagaing pageData></@pagaing>
            </div>
        </div>

        <#include "include/right.ftl" />
    </div>
</div>

</@layout>