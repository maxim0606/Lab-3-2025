import functions.*;

public class ExceptionTest {
    public static void main(String[] args) {
        System.out.println("=== ТЕСТИРОВАНИЕ ИСКЛЮЧЕНИЙ ===\n");

        testArrayTabulatedFunctionExceptions();
        testLinkedListTabulatedFunctionExceptions();
        testCommonExceptions();

        System.out.println("=== ТЕСТИРОВАНИЕ ЗАВЕРШЕНО ===");
    }

    public static void testArrayTabulatedFunctionExceptions() {
        System.out.println("1. ТЕСТИРОВАНИЕ ArrayTabulatedFunction:\n");

        // Тест 1: Некорректные границы в конструкторе
        System.out.println("Тест 1: Некорректные границы");
        try {
            TabulatedFunction func = new ArrayTabulatedFunction(5, 3, 5);
            System.out.println("ОШИБКА: Исключение не было выброшено!");
        } catch (IllegalArgumentException e) {
            System.out.println("Поймано ожидаемое исключение: " + e.getMessage());
        }

        // Тест 2: Слишком мало точек
        System.out.println("\nТест 2: Слишком мало точек");
        try {
            TabulatedFunction func = new ArrayTabulatedFunction(0, 5, 1);
            System.out.println("ОШИБКА: Исключение не было выброшено!");
        } catch (IllegalArgumentException e) {
            System.out.println("Поймано ожидаемое исключение: " + e.getMessage());
        }

        // Тест 3: Выход за границы массива
        System.out.println("\nТест 3: Выход за границы массива");
        try {
            TabulatedFunction func = new ArrayTabulatedFunction(0, 5, 3);
            func.getPoint(10); // Неверный индекс
            System.out.println("ОШИБКА: Исключение не было выброшено!");
        } catch (FunctionPointIndexOutOfBoundsException e) {
            System.out.println("Поймано ожидаемое исключение: " + e.getMessage());
        }

        // Тест 4: Некорректная установка точки (нарушение порядка X)
        System.out.println("\nТест 4: Нарушение порядка X при установке точки");
        try {
            TabulatedFunction func = new ArrayTabulatedFunction(0, 5, 3);
            func.setPoint(1, new FunctionPoint(10, 5)); // X больше следующей точки
            System.out.println("ОШИБКА: Исключение не было выброшено!");
        } catch (InappropriateFunctionPointException e) {
            System.out.println("Поймано ожидаемое исключение: " + e.getMessage());
        }

        // Тест 5: Удаление точки при малом количестве точек
        System.out.println("\nТест 5: Удаление точки при малом количестве");
        try {
            TabulatedFunction func = new ArrayTabulatedFunction(0, 2, 2); // Всего 2 точки
            func.deletePoint(0);
            System.out.println("ОШИБКА: Исключение не было выброшено!");
        } catch (IllegalStateException e) {
            System.out.println("Поймано ожидаемое исключение: " + e.getMessage());
        }

        // Тест 6: Добавление точки с существующим X
        System.out.println("\nТест 6: Добавление точки с существующим X");
        try {
            TabulatedFunction func = new ArrayTabulatedFunction(0, 5, 3);
            func.addPoint(new FunctionPoint(2.5, 10)); // X уже существует
            System.out.println("ОШИБКА: Исключение не было выброшено!");
        } catch (InappropriateFunctionPointException e) {
            System.out.println("Поймано ожидаемое исключение: " + e.getMessage());
        }

        // Тест 7: Установка null точки
        System.out.println("\nТест 7: Установка null точки");
        try {
            TabulatedFunction func = new ArrayTabulatedFunction(0, 5, 3);
            func.setPoint(1, null);
            System.out.println("ОШИБКА: Исключение не было выброшено!");
        } catch (InappropriateFunctionPointException e) {
            System.out.println("Поймано ожидаемое исключение: " + e.getMessage());
        }
    }

    public static void testLinkedListTabulatedFunctionExceptions() {
        System.out.println("\n\n2. ТЕСТИРОВАНИЕ LinkedListTabulatedFunction:\n");

        // Тест 1: Некорректные границы в конструкторе
        System.out.println("Тест 1: Некорректные границы");
        try {
            TabulatedFunction func = new LinkedListTabulatedFunction(5, 3, 5);
            System.out.println("ОШИБКА: Исключение не было выброшено!");
        } catch (IllegalArgumentException e) {
            System.out.println("Поймано ожидаемое исключение: " + e.getMessage());
        }

        // Тест 2: Слишком мало точек
        System.out.println("\nТест 2: Слишком мало точек");
        try {
            TabulatedFunction func = new LinkedListTabulatedFunction(0, 5, 1);
            System.out.println("ОШИБКА: Исключение не было выброшено!");
        } catch (IllegalArgumentException e) {
            System.out.println("Поймано ожидаемое исключение: " + e.getMessage());
        }

        // Тест 3: Выход за границы списка
        System.out.println("\nТест 3: Выход за границы списка");
        try {
            TabulatedFunction func = new LinkedListTabulatedFunction(0, 5, 3);
            func.getPoint(10); // Неверный индекс
            System.out.println("ОШИБКА: Исключение не было выброшено!");
        } catch (FunctionPointIndexOutOfBoundsException e) {
            System.out.println("Поймано ожидаемое исключение: " + e.getMessage());
        }

        // Тест 4: Некорректная установка точки (нарушение порядка X)
        System.out.println("\nТест 4: Нарушение порядка X при установке точки");
        try {
            TabulatedFunction func = new LinkedListTabulatedFunction(0, 5, 3);
            func.setPoint(1, new FunctionPoint(10, 5)); // X больше следующей точки
            System.out.println("ОШИБКА: Исключение не было выброшено!");
        } catch (InappropriateFunctionPointException e) {
            System.out.println("Поймано ожидаемое исключение: " + e.getMessage());
        }

        // Тест 5: Удаление точки при малом количестве точек
        System.out.println("\nТест 5: Удаление точки при малом количестве");
        try {
            TabulatedFunction func = new LinkedListTabulatedFunction(0, 2, 2); // Всего 2 точки
            func.deletePoint(0);
            System.out.println("ОШИБКА: Исключение не было выброшено!");
        } catch (IllegalStateException e) {
            System.out.println("Поймано ожидаемое исключение: " + e.getMessage());
        }

        // Тест 6: Добавление точки с существующим X
        System.out.println("\nТест 6: Добавление точки с существующим X");
        try {
            TabulatedFunction func = new LinkedListTabulatedFunction(0, 5, 3);
            func.addPoint(new FunctionPoint(2.5, 10)); // X уже существует
            System.out.println("ОШИБКА: Исключение не было выброшено!");
        } catch (InappropriateFunctionPointException e) {
            System.out.println("Поймано ожидаемое исключение: " + e.getMessage());
        }
    }

    public static void testCommonExceptions() {
        System.out.println("\n\n3. ОБЩИЕ ТЕСТЫ ДЛЯ ОБОИХ РЕАЛИЗАЦИЙ:\n");

        TabulatedFunction[] functions = {
                new ArrayTabulatedFunction(0, 5, 4),
                new LinkedListTabulatedFunction(0, 5, 4)
        };

        String[] types = { "ArrayTabulatedFunction", "LinkedListTabulatedFunction" };

        for (int i = 0; i < functions.length; i++) {
            System.out.println("Тестирование " + types[i] + ":");

            TabulatedFunction func = functions[i];

            // Тест получения X с неверным индексом
            try {
                func.getPointX(-1);
                System.out.println("ОШИБКА: Исключение не было выброшено для getPointX(-1)!");
            } catch (FunctionPointIndexOutOfBoundsException e) {
                System.out.println("getPointX(-1): " + e.getMessage());
            }

            // Тест получения Y с неверным индексом
            try {
                func.getPointY(10);
                System.out.println("ОШИБКА: Исключение не было выброшено для getPointY(10)!");
            } catch (FunctionPointIndexOutOfBoundsException e) {
                System.out.println("getPointY(10): " + e.getMessage());
            }

            // Тест установки X с нарушением порядка
            try {
                func.setPointX(1, 10); // X больше следующей точки
                System.out.println("ОШИБКА: Исключение не было выброшено для setPointX!");
            } catch (InappropriateFunctionPointException e) {
                System.out.println("setPointX с нарушением порядка: " + e.getMessage());
            }

            // Тест установки Y с неверным индексом
            try {
                func.setPointY(100, 5);
                System.out.println("ОШИБКА: Исключение не было выброшено для setPointY(100)!");
            } catch (FunctionPointIndexOutOfBoundsException e) {
                System.out.println("setPointY(100): " + e.getMessage());
            }

            System.out.println();
        }

        // Тест FunctionNode исключений
        System.out.println("4. ТЕСТИРОВАНИЕ FunctionNode:");
        try {
            FunctionNode node = new FunctionNode(null);
            node.getPoint(); // Должно вызвать исключение
            System.out.println("ОШИБКА: Исключение не было выброшено для FunctionNode с null point!");
        } catch (IllegalStateException e) {
            System.out.println("FunctionNode с null point: " + e.getMessage());
        }
    }
}