package com.any.twothirteenmockito.service;

import java.util.Collection;
import java.util.List;

import com.any.twothirteenmockito.exceptions.EmployeeExistsException;
import com.any.twothirteenmockito.exceptions.EmployeeNotFoundException;
import com.any.twothirteenmockito.model.Employee;
import com.any.twothirteenmockito.service.impl.EmployeeServiceImpl;
import org.junit.jupiter.api.Test;

import static com.any.twothirteenmockito.service.Data.DEPARTMENT;
import static com.any.twothirteenmockito.service.Data.EMPLOYEE;
import static com.any.twothirteenmockito.service.Data.FIRST_NAME;
import static com.any.twothirteenmockito.service.Data.SALARY;
import static com.any.twothirteenmockito.service.Data.SECOND_NAME;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EmployeeServiceTest {

    private final EmployeeServiceImpl out = new EmployeeServiceImpl();

    @Test
    public void addEmployee() {
        assertThrows(EmployeeNotFoundException.class, () -> out.getAllEmployee().size()); // проверяем исключение, когда список пуст
        Employee actual = out.addEmployee(FIRST_NAME, SECOND_NAME, DEPARTMENT, SALARY); // добавляем элемент в список
        assertEquals(EMPLOYEE, actual);  //проверяем есть ли в списке тет сотрудник который мы добавили
        assertEquals(1, out.getAllEmployee().size()); // expect 1 не очень поняла, что значит, но теоретически предположу, что проверяет что в список был добавлен один элемент
    }

    @Test
    public void addEmployeeWithExistsException() { // проверяем, что сотрудник уже есть в списке при создании новой записи через исключение
        Employee actual = out.addEmployee(FIRST_NAME, SECOND_NAME, DEPARTMENT, SALARY); // добавляем
        assertTrue(out.getAllEmployee().contains(actual)); //убеждаемся, что новый элемент есть в списке
        assertEquals(1, out.getAllEmployee().size()); // пока не разобрала что означает expect 1
        assertThrows(EmployeeExistsException.class, () -> out.addEmployee(FIRST_NAME, SECOND_NAME, DEPARTMENT, SALARY)); // если сотрудник существует, показывает ошибку
    }

    @Test
    public void findEmployee() {
        out.addEmployee(FIRST_NAME, SECOND_NAME, DEPARTMENT, SALARY); //чтобы проверить есть ли сотрудник, нужно сначала его добавить. Кстати вот эта разница между моками где мы не использовали add, а уже заранее задавали какой-то существующий список или сотрудника
        Employee result = new Employee(FIRST_NAME, SECOND_NAME);
        assertEquals(result, out.findEmployee(FIRST_NAME, SECOND_NAME));
    }

    @Test
    public void findEmployeeWithNotFoundException() { //проверяем сработает ли исключение при поиске сотрудника
        assertThrows(EmployeeNotFoundException.class, () -> out.findEmployee(FIRST_NAME, SECOND_NAME));
    }

    @Test
    public void removeEmployee() { //удаляем сотрудника, но чтобы что-то удалить нужно сначала в него добавить
        out.addEmployee(FIRST_NAME, SECOND_NAME, DEPARTMENT, SALARY);
        assertEquals(1, out.getAllEmployee().size()); // проверяем что список изменился
        out.removeEmployee(FIRST_NAME, SECOND_NAME);//потом удаляем
        assertThrows(EmployeeNotFoundException.class, () -> out.getAllEmployee().size()); // и проверяем что получим ошибку, т.к. элемент удалили
    }

    @Test
    public void removeEmployeeWithNotFoundException() { // проверяем, что метод remove выдаст исключение, когда такого элемента нет в списке
        assertThrows(EmployeeNotFoundException.class, () -> out.removeEmployee(FIRST_NAME, SECOND_NAME)); //тут мы ничего не добавляли, соответственно сработает исключение
    }


    @Test
    public void shouldReturnListOfEmployeesWhenTheyExist() { // вот этот тест не совсем понятен
        out.addEmployee(FIRST_NAME, SECOND_NAME, DEPARTMENT, SALARY); // добавляем сотрудника
        Collection<Employee> expected = List.of(EMPLOYEE); //список сотрудников в виде коллекции, изменяемый EMPLOYEE
        Collection<Employee> actual = out.getAllEmployee(); //проверяем, то что есть в списке сотрудников, т.к. выше мы добавили сотрудника, его скорее всего и покажет
        assertIterableEquals(expected, actual); //пришлось загуглить метод. Проверяем, что то добавили в список и то что там есть это правда
    }
}
