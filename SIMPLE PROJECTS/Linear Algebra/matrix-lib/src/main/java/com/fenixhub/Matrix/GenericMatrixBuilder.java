package com.fenixhub.Matrix;

import java.util.Random;

public interface GenericMatrixBuilder<T extends Number> {
    
    long randomSeed = 1234L;
    Random generator = new Random(randomSeed);

    public GenericMatrixBuilder<T> fromArray(T[][] array);

    public GenericMatrixBuilder<T> ofRandom(int nRows, int nColumns, T min, T max);

    public GenericMatrixBuilder<T> ofRandom(int nRows, int nColumns);

    public GenericMatrix<T> build();

}
