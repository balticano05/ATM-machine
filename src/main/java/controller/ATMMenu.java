package controller;

import entity.Card;
import service.ATMService;
import service.ATMServiceImpl;
import utils.MenuConstants;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;

public class ATMMenu implements Menu {

    private static Scanner sc;

    public ATMMenu() {
        sc = new Scanner(System.in);
    }

    @Override
    public void runSession() {

        AtomicBoolean isRunning = new AtomicBoolean(true);

        while (isRunning.get()) {

            MenuConstants.logo();
            MenuConstants.session();

            System.out.print("Введите значение: ");
            String choice = sc.nextLine();

            SmallSessionImpl atmSmallSession = new SmallSessionImpl();

            Map<String, Consumer<Void>> actions = new HashMap<>();

            actions.put("1", (Void) -> atmSmallSession.handleCardSession());
            actions.put("2", (Void) -> {
                System.out.println("Выход из системы...");
                isRunning.set(false); // Установить флаг для выхода из цикла
            });

            actions.getOrDefault(choice, (Void) -> System.out.println("Некорректный выбор. Попробуйте снова.")).accept(null);

        }
    }

    @Override
    public void menuAction(Card card) {

        AtomicBoolean isRunning = new AtomicBoolean(true);
        Scanner sc = new Scanner(System.in);
        ATMService atmService = new ATMServiceImpl();

        Map<String, Consumer<Void>> actions = new HashMap<>();
        actions.put("1", (Void) -> atmService.checkBalance(card));
        actions.put("2", (Void) -> atmService.withdrawMoney(card));
        actions.put("3", (Void) -> atmService.depositMoney(card));
        actions.put("4", (Void) -> {
            System.out.println("Заберите карточку.");
            isRunning.set(false); // Установить флаг для выхода из цикла
        });

        while (isRunning.get()) {
            MenuConstants.menu();
            System.out.print("Введите значение: ");
            String choice = sc.nextLine();

            actions.getOrDefault(choice, (Void) -> System.out.println("Некорректный выбор. Попробуйте снова.")).accept(null);
        }
    }
}