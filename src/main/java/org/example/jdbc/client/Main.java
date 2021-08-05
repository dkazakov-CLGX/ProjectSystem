package org.example.jdbc.client;

import lombok.SneakyThrows;
import org.example.jdbc.model.Developer;
import org.example.jdbc.model.Project;
import org.example.jdbc.services.DeveloperServiceImpl;
import org.example.jdbc.services.ProjectServiceImpl;

import java.util.List;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {

//        ProjectServiceImpl projectService = new ProjectServiceImpl();
//        List<Project> all = projectService.findAll();
//        System.out.println(all);

//        DeveloperServiceImpl developerService = new DeveloperServiceImpl();
//        List<Developer> developerServiceAll = developerService.findAll();
        List<Developer> all = new DeveloperServiceImpl().findAll();
        System.out.println(all.size());
        System.out.println(all.get(50));

//        Developer developerServiceByID = developerService.findByID(1L);
//        System.out.println(developerServiceByID);
//        GetQueryServiceImpl getQueryServiceImpl = new GetQueryServiceImpl();
//
//        //        Новый разработчик
//        DeveloperServiceImpl developerService = new DeveloperServiceImpl();
//        developerService.create(Developer.builder()
//                .developerID(14L)
//                .companyID(2L)
//                .age(23L)
//                .name("Рыжий")
//                .email("asd@asd.asd")
//                .gender("Male")
//                .numberPhone(12345L)
//                .salary(1111L)
//                .build());

        //      Новый проект
//        ProjectServiceImpl projectService = new ProjectServiceImpl();
//        projectService.create(Project.builder()
//                .id(4L)
//                .name("New Project")
//                .cost(123456L)
//                .companyID(3L)
//                .customerID(1L)
//                .build());

        //     Новый клиент
//        CustomerServiceImpl customerService = new CustomerServiceImpl();
//        customerService.create(Customer.builder()
//                .id(4L)
//                .name("Customer4")
//                .budget(1000000L)
//                .companyID(2L)
//                .build());

        // изменить разработчика
        // default -(4,'Витя', 27, 'Male', 'abc3@com.ua', 8765434,1,5600),
//        developerService.update(4L, Developer.builder()
//                .name("newName")
//                .age(33L)
//                .numberPhone(1234567L)
//                .companyID(1L)
//                .salary(600L)
//                .gender("Male")
//                .email("abcder3@com.ua")
//                .build());

        // удалить - разработчика/проект/клиента
//        developerService.delete(14L);
//        projectService.delete(4L);
//        customerService.delete(4L);

        //  все юзеры 1-ого проекта по айди   - done
//        System.out.println(getQueryServiceImpl.getDevelopersByProjectID(1L));
//        //  сумма всех зарплат 1-ого проекта  -  done
//        System.out.println(getQueryServiceImpl.getSumSalariesByProjectID(1L));
//        // список всех Java  - done
//        System.out.println(getQueryServiceImpl.getDevelopersByActivity("Java"));
//        // список юзеров middle  -  done
//        System.out.println(getQueryServiceImpl.getDevelopersByLevel("middle"));
//        //список проектов в формате: дата создания - название проекта - количество разработчиков на этом проекте.
//        System.out.println(getQueryServiceImpl.projectsWithCountDevelopers());


//        Map<Long, Developer> testMap = new HashMap<>();
//        Developer developer = Developer.builder()
//                .developerID(20L)
//                .name("User1")
//                .age(10L)
//                .gender("Male")
//                .email("abc1@a")
//                .numberPhone(123345L)
//                .salary(1000L)
//                .companyID(1L)
//                .build();
//        testMap.put(developer.getDeveloperID(), developer);
//
//        Developer developer1 = Developer.builder()
//                .developerID(21L)
//                .name("User2")
//                .age(10L)
//                .gender("Male")
//                .email("abc1@a")
//                .numberPhone(123345L)
//                .salary(1000L)
//                .companyID(1L)
//                .build();
//        testMap.put(developer1.getDeveloperID(), developer1);
//
//        Developer developer2 = Developer.builder()
//                .developerID(22L)
//                .name("User3")
//                .age(10L)
//                .gender("Male")
//                .email("abc1@a")
//                .numberPhone(123345L)
//                .salary(1000L)
//                .companyID(1L)
//                .build();
//        testMap.put(developer2.getDeveloperID(), developer2);
//
//        System.out.println(testMap);
//        Stream<Developer> developerStream = testMap.values().stream();
//        Stream<Developer> developerStream1 = developerStream.filter((testMap1) -> developer.getName().contains("1"));
//        System.out.println(developerStream);
//        System.out.println(Arrays.toString(developerStream1.toArray()));

    }
}
