package config;

import domain.Client;
import domain.Contract;
import domain.Option;
import domain.Tariff;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;
import javax.sql.DataSource;
import java.util.Properties;


@Configuration
@EnableWebMvc
//@EnableTransactionManagement
@ComponentScan(basePackages = {"controllers", "dao", "service"})
public class SpringWebConfig extends WebMvcConfigurerAdapter  {


    @Bean
    public ViewResolver getViewResolver() {
        FreeMarkerViewResolver freeMarkerViewResolver = new FreeMarkerViewResolver();
        freeMarkerViewResolver.setOrder(1);
        freeMarkerViewResolver.setSuffix(".ftl");
        return freeMarkerViewResolver;
    }

    @Bean
    public FreeMarkerConfigurer getFreemarkerConfigurer() {
        FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer();
        freeMarkerConfigurer.setTemplateLoaderPaths("/", "/WEB-INF/views/");
        return freeMarkerConfigurer;
    }

    @Bean
    @Scope("prototype")
    public Client getClient() {
        return new Client();
    }

    @Bean
    @Scope("prototype")
    public Contract getContract() {
        return new Contract();
    }

    @Bean
    @Scope("prototype")
    public Option getOption() {
        return new Option();
    }

    @Bean
    @Scope("prototype")
    public Tariff getTariff() {
        return new Tariff();
    }

//    @Bean
//    public DataSource getDataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("org.postgresql.Driver");
//        dataSource.setUrl("jdbc:postgresql://localhost:5432/mobileApp");
//        dataSource.setUsername("postgres");
//        dataSource.setPassword("papercut");
//        return dataSource;
//    }
//
//    @Bean
//    public SessionFactory getSessionFactory(DataSource dataSource) {
//        LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
//        Properties properties = new Properties();
//        properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
//        properties.put("hibernate.show_sql", "true");
//        properties.put("hibernate.hbm2ddl.auto", "update");
//        sessionBuilder.addProperties(properties);
//        sessionBuilder.addAnnotatedClass(Client.class);
//        sessionBuilder.addAnnotatedClass(Option.class);
//        sessionBuilder.addAnnotatedClass(Contract.class);
//        sessionBuilder.addAnnotatedClass(Tariff.class);
//        return sessionBuilder.buildSessionFactory();
//    }
//
//    @Bean
//    public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
//        return new HibernateTransactionManager(sessionFactory);
//    }

}
