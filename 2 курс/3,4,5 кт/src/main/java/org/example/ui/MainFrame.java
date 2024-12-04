package org.example.ui;

import org.example.model.RoutePoint;
import org.example.model.Train;
import org.example.service.RoutePointService;
import org.example.service.TrainService;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MainFrame extends JFrame {
    private final TrainService trainService;
    private final RoutePointService routePointService;

    public MainFrame() {
        trainService = new TrainService();
        routePointService = new RoutePointService();

        setTitle("Управление маршрутами поездов");
        setSize(900, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new FlowLayout());
        JButton addTrainButton = new JButton("Добавить поезд");
        JButton viewTrainsButton = new JButton("Просмотреть все маршруты");
        JButton addRoutePointButton = new JButton("Добавить пункт маршрута");
        JButton editRoutePointButton = new JButton("Изменить пункт маршрута");
        JButton deleteRoutePointButton = new JButton("Удалить пункт маршрута");
        JButton viewRoutePointsButton = new JButton("Просмотреть маршруты поезда");

        topPanel.add(addTrainButton);
        topPanel.add(viewTrainsButton);
        topPanel.add(addRoutePointButton);
        topPanel.add(editRoutePointButton);
        topPanel.add(deleteRoutePointButton);
        topPanel.add(viewRoutePointsButton);

        JTextArea outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        addTrainButton.addActionListener(e -> addTrain());
        viewTrainsButton.addActionListener(e -> viewTrains(outputArea));
        addRoutePointButton.addActionListener(e -> addRoutePoint());
        editRoutePointButton.addActionListener(e -> editRoutePoint());
        deleteRoutePointButton.addActionListener(e -> deleteRoutePoint());
        viewRoutePointsButton.addActionListener(e -> viewRoutePoints(outputArea));
    }

    private void addTrain() {
        String trainNumber = JOptionPane.showInputDialog(this, "Введите номер поезда:");
        String routeName = JOptionPane.showInputDialog(this, "Введите название маршрута:");
        if (trainNumber != null && routeName != null) {
            try {
                Train train = new Train(0, trainNumber, routeName);
                trainService.addTrain(train);
                JOptionPane.showMessageDialog(this, "Поезд успешно добавлен!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Ошибка: " + ex.getMessage());
            }
        }
    }

    private void viewTrains(JTextArea outputArea) {
        try {
            List<Train> trains = trainService.getAllTrains();
            StringBuilder sb = new StringBuilder("Маршруты всех поездов:\n");
            for (Train train : trains) {
                sb.append("Поезд: ").append(train.getTrainNumber())
                        .append(", Маршрут: ").append(train.getRouteName()).append("\n");
            }
            outputArea.setText(sb.toString());
        } catch (Exception ex) {
            outputArea.setText("Ошибка: " + ex.getMessage());
        }
    }

    private void addRoutePoint() {
        try {
            String trainIdStr = JOptionPane.showInputDialog(this, "Введите ID маршрута:");
            int trainId = Integer.parseInt(trainIdStr);

            String stationName = JOptionPane.showInputDialog(this, "Введите название станции:");
            String arrivalTime = JOptionPane.showInputDialog(this, "Введите время прибытия (чч:мм):");
            String departureTime = JOptionPane.showInputDialog(this, "Введите время отправления (чч:мм):");

            if (stationName != null && arrivalTime != null && departureTime != null) {
                RoutePoint point = new RoutePoint(0, trainId, stationName, arrivalTime, departureTime);
                routePointService.addRoutePoint(point);
                JOptionPane.showMessageDialog(this, "Пункт маршрута успешно добавлен!");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Ошибка: " + ex.getMessage());
        }
    }

    private void editRoutePoint() {
        try {
            String pointIdStr = JOptionPane.showInputDialog(this, "Введите ID пункта маршрута:");
            int pointId = Integer.parseInt(pointIdStr);

            String stationName = JOptionPane.showInputDialog(this, "Введите новое название станции:");
            String arrivalTime = JOptionPane.showInputDialog(this, "Введите новое время прибытия (чч:мм):");
            String departureTime = JOptionPane.showInputDialog(this, "Введите новое время отправления (чч:мм):");

            if (stationName != null && arrivalTime != null && departureTime != null) {
                RoutePoint point = new RoutePoint(pointId, 0, stationName, arrivalTime, departureTime);
                routePointService.updateRoutePoint(point);
                JOptionPane.showMessageDialog(this, "Пункт маршрута успешно обновлен!");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Ошибка: " + ex.getMessage());
        }
    }

    private void deleteRoutePoint() {
        try {
            String pointIdStr = JOptionPane.showInputDialog(this, "Введите ID пункта маршрута:");
            int pointId = Integer.parseInt(pointIdStr);

            routePointService.deleteRoutePoint(pointId);
            JOptionPane.showMessageDialog(this, "Пункт маршрута успешно удален!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Ошибка: " + ex.getMessage());
        }
    }

    private void viewRoutePoints(JTextArea outputArea) {
        try {
            String trainIdStr = JOptionPane.showInputDialog(this, "Введите ID маршрута для просмотра:");
            int trainId = Integer.parseInt(trainIdStr);

            List<RoutePoint> points = routePointService.getRoutePointsByTrainId(trainId);
            Train train = trainService.getTrainByNumber(trainIdStr);
            StringBuilder sb = new StringBuilder("Маршрут поезда ").append(train.getTrainNumber())
                    .append(" - ").append(train.getRouteName()).append(":\n");

            for (RoutePoint point : points) {
                sb.append(point.getStationName())
                        .append(" - Прибытие: ").append(point.getArrivalTime())
                        .append(", Отправление: ").append(point.getDepartureTime()).append("\n");
            }
            outputArea.setText(sb.toString());
        } catch (Exception ex) {
            outputArea.setText("Ошибка: " + ex.getMessage());
        }
    }
}