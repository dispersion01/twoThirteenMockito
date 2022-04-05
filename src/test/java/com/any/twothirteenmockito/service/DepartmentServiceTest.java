package com.any.twothirteenmockito.service;

import com.any.twothirteenmockito.exceptions.EmployeeNotFoundException;
import com.any.twothirteenmockito.service.impl.DepartmentServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.any.twothirteenmockito.service.Data.DEPARTMENT;
import static com.any.twothirteenmockito.service.Data.DEPARTMENT2;
import static com.any.twothirteenmockito.service.Data.DEPARTMENTS_MAP;
import static com.any.twothirteenmockito.service.Data.EMPLOYEE;
import static com.any.twothirteenmockito.service.Data.EMPLOYEE2;
import static com.any.twothirteenmockito.service.Data.EMPLOYEES;
import static com.any.twothirteenmockito.service.Data.EMPLOYEES2;
import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {

    @Mock
    private EmployeeService employeeService; //создание мока. т.к. сервисе зависимость от департамента

    @InjectMocks
    private DepartmentServiceImpl out; //его реализация

    @Test
    public void findEmployeeWithMaxSalaryByDepartmentId() { //показывает, что максимальная зарплата найдена(присутствует)
        when(employeeService.getAllEmployee()).thenReturn(EMPLOYEES); //ожидаем, что EMPLOYEES есть в списке, при возвращении всех сотрудников
        assertEquals(EMPLOYEE2, out.findEmployeeWithMaxSalaryByDepartmentId(DEPARTMENT)); //сравнивает что в EMPLOYEE2 присутствует тот департамент который нам нужен
    }

    @Test
    public void findEmployeeWithMaxSalaryByDepartmentIdWithNotFoundException() { //тоже самое, что в предыдущем тесте,
        when(employeeService.getAllEmployee()).thenReturn(emptyList());          //только тут проверяем что сработает исключение, когда список пуст
        assertThrows(EmployeeNotFoundException.class, () -> out.findEmployeeWithMaxSalaryByDepartmentId(DEPARTMENT));
    }

    @Test
    public void findEmployeeWithMaxSalaryByDepartmentIdWithNotFoundExceptionWithBadDepartment() { // тоже добиваемся исключения, через лямбду, когда с несоответствующим департаментом
        when(employeeService.getAllEmployee()).thenReturn(EMPLOYEES);
        assertThrows(EmployeeNotFoundException.class, () -> out.findEmployeeWithMaxSalaryByDepartmentId(DEPARTMENT2));
    }

    @Test
    public void findEmployeeWithMinSalaryByDepartmentId() { //показывает, что минимальная зарплата найдена
        when(employeeService.getAllEmployee()).thenReturn(EMPLOYEES);
        assertEquals(EMPLOYEE, out.findEmployeeWithMinSalaryByDepartmentId(DEPARTMENT));
    }

    @Test
    public void findEmployeeWithMinSalaryByDepartmentIdWithNotFoundException() { //тоже самое, что и у максимальной зарплаты было выше, но для минимальной пытаемся проверить что сработает исключение
        when(employeeService.getAllEmployee()).thenReturn(emptyList());
        assertThrows(EmployeeNotFoundException.class, () -> out.findEmployeeWithMinSalaryByDepartmentId(DEPARTMENT));
    }

    @Test
    public void findEmployeeWithMinSalaryByDepartmentIdWithNotFoundExceptionWithBadDepartment() { //аналогично проверяем исключение
        when(employeeService.getAllEmployee()).thenReturn(EMPLOYEES);
        assertThrows(EmployeeNotFoundException.class, () -> out.findEmployeeWithMinSalaryByDepartmentId(DEPARTMENT2));
    }

    @Test
    public void findAllEmployeeByDepartmentId() {
        when(employeeService.getAllEmployee()).thenReturn(EMPLOYEES2);
        assertEquals(DEPARTMENTS_MAP, out.findAllEmployeeByDepartmentId()); //тут не очень поняла что означает DEPARTMENTS_MAP и каким образом его получаем
        // теоретически нам надо было проверить покажет ли метод все что есть в списке сотрудников
        // но для этого нужно чтобы в списке что-то было и несколько значений
        // в обычном тесте мы могли бы сделать через метод add добавить объекты и потом показать их список
        // но будет ли правильным это делать с моками
    }


}
