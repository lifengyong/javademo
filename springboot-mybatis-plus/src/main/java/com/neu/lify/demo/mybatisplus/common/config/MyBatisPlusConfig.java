package com.neu.lify.demo.mybatisplus.common.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.autoconfigure.ConfigurationCustomizer;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class MyBatisPlusConfig {

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer configurer = new MapperScannerConfigurer();
        configurer.setBasePackage("com.neu.lify.demo.mybatisplus.module.*.mapper");
        return configurer;
    }

    /**
     * 新的分页插件,一缓和二缓遵循mybatis的规则,需要设置 MybatisConfiguration#useDeprecatedExecutor = false 避免缓存出现问题
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        /*注意:
            使用多个功能需要注意顺序关系,建议使用如下顺序
            1.多租户,动态表名
            2.分页,乐观锁
            3.sql性能规范,防止全表更新与删除
          总结: 对sql进行单次改造的优先放入,不对sql进行改造的最后放入
         */
        //对于单一数据库类型来说,都建议配置该值,避免每次分页都去抓取数据库类型
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        //乐观锁配置：仅支持 updateById(id) 与 update(entity, wrapper) 方法，在 update(entity, wrapper) 方法下, wrapper 不能复用!!!
        interceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
        return interceptor;
    }

    @Bean
    public ConfigurationCustomizer configurationCustomizer() {
        //该属性将会随着 com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor 插件的移除而移除，但是为了避免缓存出现问题还需要这样设置
        return configuration -> configuration.setUseDeprecatedExecutor(false);
    }

//    @Bean
//    public Jackson2ObjectMapperBuilderCustomizer jacksonEnumsCustomizer(){
//        //序列化枚举值为数据库存储值,重写toString方法
//        return builder -> builder.featuresToEnable(SerializationFeature.WRITE_ENUMS_USING_TO_STRING);
//    }

}
