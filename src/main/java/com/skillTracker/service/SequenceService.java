package com.skillTracker.service;



public interface SequenceService {

    /**

     * Generates custom sequences

     *

     * @param sequenceName

     * @return Integer

     */

    Integer getNextSequence(String sequenceName);

}


