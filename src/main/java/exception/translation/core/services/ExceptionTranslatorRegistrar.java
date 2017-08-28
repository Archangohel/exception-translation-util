package exception.translation.core.services;

import exception.translation.core.translators.AbstractExceptionTranslator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;


/**
 * @auther Archan on 28/08/17.
 */
@Component("exceptionTranslatorRegistrar")
public class ExceptionTranslatorRegistrar implements BeanPostProcessor {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ExceptionTranslationService exceptionTranslationService;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        logger.trace("postProcessAfterInitialization for bean {} , beanName {}", bean, beanName);
        if (AbstractExceptionTranslator.class.isAssignableFrom(bean.getClass())) {
            exceptionTranslationService.registerTranslator((AbstractExceptionTranslator) bean);
        }
        return bean;
    }

}
