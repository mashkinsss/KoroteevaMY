/* Вариант 6. 
Необходимо создать приложение для учета маршрутов пассажирских поездов. 
Маршрут поезда состоит из пункта отправления, пункта прибытия и промежуточных станций. 
Каждый пункт маршрута характеризуется временем прибытия и отправления. 
Приложение должно уметь создавать новый маршрут (номер поезда, название маршрута), 
добавлять/удалять/ изменять пункты маршрута (отправление, прибытие, промежуточные).
*/


import model.RoutePoint;
import model.TrainRoute;
import service.TrainRouteService;

import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        TrainRouteService routeService = new TrainRouteService();

        // Создаем начальную и конечную станции маршрута
        RoutePoint start = new RoutePoint("Станция А", LocalTime.of(8, 0), LocalTime.of(8, 10));
        RoutePoint end = new RoutePoint("Станция Б", LocalTime.of(10, 30), LocalTime.of(10, 40));

        // Создаем маршрут
        TrainRoute route = new TrainRoute("001", "Маршрут 1", start, end);
        routeService.addRoute(route);

        // Добавляем промежуточные станции
        RoutePoint mid1 = new RoutePoint("Станция Х", LocalTime.of(9, 0), LocalTime.of(9, 10));
        RoutePoint mid2 = new RoutePoint("Станция У", LocalTime.of(9, 30), LocalTime.of(9, 40));
        route.addIntermediatePoint(mid1);
        route.addIntermediatePoint(mid2);

        // Выводим созданный маршрут
        System.out.println("Созданный маршрут:");
        System.out.println(route);

        // Обновляем промежуточную станцию по id, не создавая новый объект
        route.updateIntermediatePointById(mid2.getId(), "Станция У-Обновленная", LocalTime.of(9, 35), LocalTime.of(9, 45));

        // Выводим обновленный маршрут
        System.out.println("Обновленный маршрут:");
        System.out.println(route);
    }
}
