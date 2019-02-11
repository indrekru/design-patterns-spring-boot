package com.ruubel.service.factory

import com.ruubel.service.strategy.BankScraperStrategy
import spock.lang.Specification

class ScraperFactoryServiceSpec extends Specification {

    ScraperFactoryService service

    def setup() {
        service = new ScraperFactoryService()
    }

    def "when service is initialized, then has strategies setup" () {
        expect:
            service.strategies.size() == 2
    }

    def "when getting strategies, then returns the exact list" () {
        when:
            List<BankScraperStrategy> strategies = service.getStrategies()
        then:
            service.strategies == strategies
    }

}
