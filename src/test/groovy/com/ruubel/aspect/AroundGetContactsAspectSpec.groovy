package com.ruubel.aspect

import org.aspectj.lang.ProceedingJoinPoint
import spock.lang.Specification

class AroundGetContactsAspectSpec extends Specification {

    AroundGetContactsAspect aspect

    def setup () {
        aspect = new AroundGetContactsAspect()
    }

    def "when ProceedingJoinPoint is passed, then returns the result of the proceed" () {
        given:
            ProceedingJoinPoint pjp = Mock(ProceedingJoinPoint)
            String out = "test"
        when:
            Object result = aspect.profile(pjp)
        then:
            1 * pjp.proceed() >> out
            result == out

    }

}
