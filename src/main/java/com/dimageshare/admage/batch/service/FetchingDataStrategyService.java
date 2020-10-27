package com.dimageshare.admage.batch.service;

import org.springframework.stereotype.Service;

/**
 * Interface provide methods for fetching data log, you can fetch from files or elastic search (if development).
 *
 * @author bac-ta
 * @see FetchingDataStrategyService
 * @since 2020-10-27
 */
@Service
public interface FetchingDataStrategyService {

    /**
     * Do something
     *
     * @param a variable a
     * @param b variable b
     */
    void doSomething(int a, int b);
}
