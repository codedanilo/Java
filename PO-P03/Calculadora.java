

class DivisionByZeroException extends Exception {
    public DivisionByZeroException(String message) {
        super(message);
    }
}

class Calculadora {
    private int resultado;

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }

    public int somar(int a, int b) {
        return a + b;
    }

    public int subtrair(int a, int b) {
        return a - b;
    }

    public int multiplicar(int a, int b) {
        return a * b;
    }

    public int dividir(int dividendo, int divisor) throws DivisionByZeroException {
        if (divisor == 0) {
            throw new DivisionByZeroException("A divisão por zero não é permitida.");
        }
        resultado = dividendo / divisor;
        return resultado;
    }

    public float dividir(float dividendo, float divisor) throws DivisionByZeroException {
        if (divisor == 0.0f) {
            throw new DivisionByZeroException("A divisão por zero não é permitida.");
        }
        resultado = (int) (dividendo / divisor);
        return resultado;
    }
}