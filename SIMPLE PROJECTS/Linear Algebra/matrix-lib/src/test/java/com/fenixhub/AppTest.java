package com.fenixhub;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.fenixhub.matrix.builders.GenericMatrixBuilder;
import com.fenixhub.matrix.classes.FloatMatrix;
import com.fenixhub.matrix.classes.GenericMatrix;
import com.fenixhub.matrix.utilities.MatrixOperations;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
    
    @Test
    public void shouldCreateIntegerMatrix() {
        GenericMatrix<Integer> matrix = new GenericMatrixBuilder<Integer>(Integer.class)
        .ofArray(new Integer[][] {
            {1, 2, 3},
            {4, 5, 6}
        })
        .build();
        
        assertEquals(matrix.getClazz(), Integer.class);
    }

    @Test
    public void shouldCreateShortMatrix() {
        GenericMatrix<Short> matrix = new GenericMatrixBuilder<Short>(Short.class)
        .ofArray(new Short[][] {
            {1, 2, 3},
            {4, 5, 6}
        })
        .build();
        
        assertEquals(matrix.getClazz(), Short.class);
    }

    @Test
    public void shouldCreateLongMatrix() {
        GenericMatrix<Long> matrix = new GenericMatrixBuilder<Long>(Long.class)
        .ofArray(new Long[][] {
            {1L, 2L, 3L},
            {4L, 5L, 6L}
        })
        .build();
        
        assertEquals(matrix.getClazz(), Long.class);
    }

    @Test
    public void shouldCreateFloatMatrix() {
        GenericMatrix<Float> matrix = new GenericMatrixBuilder<Float>(Float.class)
        .ofArray(new Float[][] {
            {1.0f, 2.0f, 3.0f},
            {4.0f, 5.0f, 6.0f}
        })
        .build();
        
        assertEquals(matrix.getClazz(), Float.class);
    }

    @Test
    public void shouldCreateDoubleMatrix() {
        GenericMatrix<Double> matrix = new GenericMatrixBuilder<Double>(Double.class)
        .ofArray(new Double[][] {
            {1.0, 2.0, 3.0},
            {4.0, 5.0, 6.0}
        })
        .build();
        
        assertEquals(matrix.getClazz(), Double.class);
    }

    @Test
    public void sholdCreateEmptyMatrix() {
        GenericMatrix<Float> matrix = new FloatMatrix();
        assertTrue(matrix.getRows() == 0);
    }

    @Test
    public void shouldCreate1DMatrix() {
        GenericMatrix<Float> matrix = new FloatMatrix(1, 1);
        assertTrue(matrix.getRows() == 1);
        assertTrue(matrix.getColumns() == 1);
    }

    @Test
    public void ShouldCreate2DMatrix() {
        GenericMatrix<Float> matrix = new FloatMatrix(2, 2);
        assertTrue(matrix.getRows() == 2);
        assertTrue(matrix.getColumns() == 2);
        assertTrue(matrix.isSquare());
    }

    @Test
    public void shouldCreateZerosMatrix() {
        GenericMatrix<Float> zerosMatrix = new GenericMatrixBuilder<Float>(Float.class)
        .ofZeros(2, 2)
        .build();

        for (int i = 0; i < zerosMatrix.getRows(); i++) {
            for (int j = 0; j < zerosMatrix.getColumns(); j++) {
                assertTrue(zerosMatrix.get(i, j) == 0.0f);
            }
        }
    }

    @Test
    public void shouldCreateOnesMatrix() {
        GenericMatrix<Float> onesMatrix = new GenericMatrixBuilder<Float>(Float.class)
        .ofOnes(2, 2)
        .build();

        for (int i = 0; i < onesMatrix.getRows(); i++) {
            for (int j = 0; j < onesMatrix.getColumns(); j++) {
                assertTrue(onesMatrix.get(i, j) == 1.0f);
            }
        }
    }

    @Test
    public void shouldCreateIdentityMatrix() {
        GenericMatrix<Float> identityMatrix = new GenericMatrixBuilder<Float>(Float.class)
        .ofIdentity(2, 2)
        .build();
        System.out.println(identityMatrix);
        for (int i = 0; i < identityMatrix.getRows(); i++) {
            for (int j = 0; j < identityMatrix.getColumns(); j++) {
                if (i == j) {
                    assertTrue(identityMatrix.get(i, j) == 1.0f);
                } else {
                    assertTrue(identityMatrix.get(i, j) == 0.0f);
                }
            }
        }
    }

    @Test
    public void shouldCreateRandomMatrix() {
        GenericMatrix<Float> randomMatrix = new GenericMatrixBuilder<Float>(Float.class)
        .ofRandom(2, 2)
        .build();

        for (int i = 0; i < randomMatrix.getRows(); i++) {
            for (int j = 0; j < randomMatrix.getColumns(); j++) {
                assertTrue(randomMatrix.get(i, j) >= 0.0f);
                assertTrue(randomMatrix.get(i, j) <= 1.0f);
            }
        }
    }

    @Test
    public void shouldBeEqualsMatrices() {
        GenericMatrix<Float> matrix1 = new GenericMatrixBuilder<Float>(Float.class)
        .ofOnes(2, 2)
        .build();

        GenericMatrix<Float> matrix2 = new GenericMatrixBuilder<Float>(Float.class)
        .ofOnes(2, 2)
        .build();

        assertTrue(MatrixOperations.equals(matrix1, matrix2));
    }

    @Test
    public void shouldBeCorrectScalar() {
        GenericMatrix<Float> matrix1 = new GenericMatrixBuilder<Float>(Float.class)
        .ofArray(new Float[][] {
            {2.0f, 2.0f},
            {2.0f, 2.0f}
        })
        .build();
        Float scalar = 2.f;

        GenericMatrix<Float> matrix2 = new GenericMatrixBuilder<Float>(Float.class)
        .ofOnes(2, 2)
        .build();

        assertTrue(MatrixOperations.equals(MatrixOperations.scalar(matrix2, scalar), matrix1));
    }

    @Test
    public void shouldTranspose() {
        GenericMatrix<Float> matrix1 = new GenericMatrixBuilder<Float>(Float.class)
        .ofArray(new Float[][] {
            {1.0f, 2.0f},
            {3.0f, 4.0f}
        })
        .build();

        GenericMatrix<Float> matrix2 = new GenericMatrixBuilder<Float>(Float.class)
        .ofArray(new Float[][] {
            {1.0f, 3.0f},
            {2.0f, 4.0f}
        })
        .build();

        assertTrue(MatrixOperations.equals(MatrixOperations.transpose(matrix1), matrix2));
    }

    @Test
    public void shouldBeCorrectDot() {
        GenericMatrix<Float> matrix1 = new GenericMatrixBuilder<Float>(Float.class)
        .ofArray(new Float[][] {
            {1.0f},
            {3.0f}
        })
        .build();

        GenericMatrix<Float> matrix2 = new GenericMatrixBuilder<Float>(Float.class)
        .ofArray(new Float[][] {
            {2.0f, 4.0f}
        })
        .build();

        GenericMatrix<Float> matrix3 = new GenericMatrixBuilder<Float>(Float.class)
        .ofArray(new Float[][] {
            {2.f, 4.f},
            {6.f, 12.f}
        })
        .build();

        assertTrue(MatrixOperations.equals(MatrixOperations.dot(matrix1, matrix2), matrix3));
    }

    @Test
    public void shouldBeCorrectSum() {
        GenericMatrix<Float> matrix1 = new GenericMatrixBuilder<Float>(Float.class)
        .ofArray(new Float[][] {
            {1.0f, 2.0f},
            {3.0f, 4.0f}
        })
        .build();

        GenericMatrix<Float> matrix2 = new GenericMatrixBuilder<Float>(Float.class)
        .ofArray(new Float[][] {
            {2.0f, 4.0f},
            {6.0f, 8.0f}
        })
        .build();

        GenericMatrix<Float> matrix3 = new GenericMatrixBuilder<Float>(Float.class)
        .ofArray(new Float[][] {
            {3.0f, 6.0f},
            {9.0f, 12.0f}
        })
        .build();

        assertTrue(MatrixOperations.equals(MatrixOperations.sum(matrix1, matrix2), matrix3));
    }

    @Test
    public void shouldBeCorrectDiff() {
        GenericMatrix<Float> matrix1 = new GenericMatrixBuilder<Float>(Float.class)
        .ofArray(new Float[][] {
            {1.0f, 2.0f},
            {3.0f, 4.0f}
        })
        .build();

        GenericMatrix<Float> matrix2 = new GenericMatrixBuilder<Float>(Float.class)
        .ofArray(new Float[][] {
            {2.0f, 4.0f},
            {6.0f, 8.0f}
        })
        .build();

        GenericMatrix<Float> matrix3 = new GenericMatrixBuilder<Float>(Float.class)
        .ofArray(new Float[][] {
            {-1.0f, -2.0f},
            {-3.0f, -4.0f}
        })
        .build();

        assertTrue(MatrixOperations.equals(MatrixOperations.sum(matrix1, MatrixOperations.scalar(matrix2, -1.f)), matrix3));
    }

    @Test
    public void shouldBeCorrectDeterminant() {
        GenericMatrix<Float> matrix1 = new GenericMatrixBuilder<Float>(Float.class)
        .ofArray(new Float[][] {
            {1.0f, 2.0f, 3.0f},
            {4.0f, 5.0f, 6.0f},
            {7.0f, 8.0f, 9.0f}
        })
        .build();

        assertTrue(MatrixOperations.determinant(matrix1) == 0.0f);
    }
}
