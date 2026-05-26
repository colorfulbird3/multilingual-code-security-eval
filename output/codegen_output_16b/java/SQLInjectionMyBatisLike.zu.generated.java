

<h3 id="mybatis.config">Mybatis Config</h3>

<pre class="code">
    &lt;includedir&gt;src/main/resources/mapper&lt;/includedir&gt;
    &lt;includedir&gt;src/main/resources/mybatis-config&lt;/includedir&gt;
</pre>

<h3 id="mybatis.xml">Mybatis XML</h3>

<pre class="code">
    &lt;?xml version="1.0" encoding="UTF-8"?&gt;
    &lt;!DOCTYPE configuration SYSTEM "http://java.sun.com/dtd/properties.dtd"&gt;
    &lt;configuration&gt;
        &lt;properties&gt;
            &lt;property name="mybatis.mapper.class" value="mybatis.mapper.ProductMapper" /&gt;
            &lt;!--... --&gt;
        &lt;/properties&gt;
        &lt;mappers&gt;
            &lt;mapper type="mybatis.mapper.ProductMapper"/&gt;
        &lt;/mappers&gt;
        &lt;environments&gt;
            &lt;environment id="development"&gt;
                &lt;settings&gt;
                    &lt;property name="mybatis.mapper.class" value="mybatis.mapper.ProductMapper" /&gt;
                    &lt;!--... --&gt;
                &lt;/settings&gt;
            &lt;/environment&gt;
        &lt;/environments&gt;
    &lt;/configuration&gt;
</pre>

<h3 id="mybatis.example">Mybatis Example</h3>

<pre class="code">
    package com.example.dao;

    import java.math.BigDecimal;
    import java.util.List;
    import java.util.Map;
    import org.apache.ibatis.annotations.Param;
    import org.apache.ibatis.