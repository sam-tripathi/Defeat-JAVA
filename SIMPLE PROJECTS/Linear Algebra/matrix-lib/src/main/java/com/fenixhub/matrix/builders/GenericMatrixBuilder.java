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

    public GenericMatrixBuilder<T> ofSize(int nRows, int nColumns) {
        this.matrix = new GenericMatrix<T>(nRows, nColumns, clazz);
        return this;
    }

    public GenericMatrixBuilder<T> ofArray(T[][] array) {
        this.matrix = new GenericMatrix<T>(array);
        return this;
    }

    public GenericMatrixBuilder<T> ofRandom(int nRows, int nColumns) {
        this.matrix = new GenericMatrix<T>(nRows, nColumns, clazz);
        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nColumns; j++) {
                this.matrix.set(i, j, MatrixOperations.castDouble(generator.nextDouble(), clazz));
            }
        }
        return this;
    }

    public GenericMatrixBuilder<T> ofRandom(int nRows, int nColumns, T min, T max) {
        this.matrix = new GenericMatrix<T>(nRows, nColumns, clazz);
        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nColumns; j++) {
                this.matrix.set(i, j, MatrixOperations.castDouble(generator.nextDouble() * (max.doubleValue() - min.doubleValue()) + min.doubleValue(), clazz));
            }
        }
        return this;
    }

    public GenericMatrixBuilder<T> ofZeros(int nRows, int nColumns) {
        this.matrix = new GenericMatrix<T>(nRows, nColumns, clazz);
        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nColumns; j++) {
                this.matrix.set(i, j, MatrixOperations.castDouble(0.0, clazz));
            }
        }
        return this;
    }

    public GenericMatrixBuilder<T> ofOnes(int nRows, int nColumns) {
        this.matrix = new GenericMatrix<T>(nRows, nColumns, clazz);
        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nColumns; j++) {
                this.matrix.set(i, j, MatrixOperations.castDouble(1.0, clazz));
            }
        }
        return this;
    }

    // Generate Identity Matrix
    public GenericMatrixBuilder<T> ofIdentity(int nRows, int nColumns) {
        this.matrix = new GenericMatrix<T>(nRows, nColumns, clazz);
        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nColumns; j++) {
                if (i == j) {
                    this.matrix.set(i, j, MatrixOperations.castDouble(1.0, clazz));
                } else {
                    this.matrix.set(i, j, MatrixOperations.castDouble(0.0, clazz));
                }
            }
        }
        return this;
    }

    public GenericMatrix<T> build() {
        return this.matrix;
    }

}
