package com.fenixhub.matrix.builders;

import java.util.Random;

import com.fenixhub.matrix.classes.GenericMatrix;
import com.fenixhub.matrix.utilities.MatrixOperations;

@SuppressWarnings("unchecked")
public class GenericMatrixBuilder<T extends Number> {
    
    private long randomSeed = 1234L;
    private Random generator = new Random(randomSeed);
    private GenericMatrix<T> matrix;
    private Class<T> clazz;

    public GenericMatrixBuilder(Class<T> clazz) {
        this.clazz = clazz;
    }

    public GenericMatrixBuilder<T> fromArray(T[][] array) {
        this.matrix = new GenericMatrix<T>(array);
        return this;
    }

    public GenericMatrixBuilder<T> fromRandom(int nRows, int nColumns, T min, T max) {
        this.matrix = new GenericMatrix<T>(nRows, nColumns, clazz);
        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nColumns; j++) {
                this.matrix.set(i, j, MatrixOperations.cast(generator.nextDouble() * (max.doubleValue() - min.doubleValue()) + min.doubleValue(), clazz));
            }
        }
        return this;
    }

    public GenericMatrix<T> build() {
        return this.matrix;
    }

}
