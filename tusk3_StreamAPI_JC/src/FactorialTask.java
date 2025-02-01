import java.util.concurrent.RecursiveTask;

class FactorialTask extends RecursiveTask<Long> {
    private final int n;

    public FactorialTask(int n) {
        this.n = n;
    }

    @Override
    protected Long compute() {
        if (n <= 1) {
            return 1L; // Базовый случай: факториал 0! и 1! равен 1
        } else {
            // Разбиваем задачу на две подзадачи
            FactorialTask subTask1 = new FactorialTask(n - 1);
            subTask1.fork(); // Асинхронно выполняем первую подзадачу

            // Вычисляем вторую подзадачу
            long result = n * subTask1.join(); // Объединяем результаты

            return result; // Возвращаем итоговый результат
        }
    }
}
