package br.com.alan.model;

import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

import static br.com.alan.model.Aviao.aviaoList;

public class Menu {
    public static void mostraMenu() {
        Scanner leitor = new Scanner(System.in);
        int opcao = 0;
        try {
            while (opcao != 5) {

                System.out.println("************************");
                System.out.println("1. Registrar Aeronaves  ");
                System.out.println("2. Alterar Aeronaves    ");
                System.out.println("3. Excluir Aeronaves    ");
                System.out.println("4. Visualizar Aeronaves ");
                System.out.println("5. Sair                 ");
                System.out.println("************************");
                System.out.println("Escolha uma opção válida: ");
                opcao = leitor.nextInt();
                switch (opcao) {
                    case 1:
                        System.out.println("Digite o modelo");
                        String modelo = leitor.next();
                        System.out.println("Digite a capacidade");
                        int capacidade = leitor.nextInt();
                        if (!modelo.isEmpty() && modelo != null) {
                            Aviao aviao = new Aviao(modelo, capacidade);
                            aviao.addList(aviao);
                            System.out.println("Aeronave cadastrada com sucesso! ");
                            System.out.println(aviao);
                        }
                        break;
                    case 2:
                        System.out.println("Digite o registro para buscar aeronave: ");
                        int regAeronave = leitor.nextInt();
                        for (Aviao a : aviaoList) {
                            if (regAeronave == a.getRegistro() && !aviaoList.isEmpty()) {
                                System.out.println("********************");
                                System.out.println("Alterar aeronaves");
                                System.out.println("********************");
                                System.out.println();
                                System.out.println("digite o modelo: ");
                                String model = leitor.next();
                                System.out.println("Digite a capacidade: ");
                                int capac = leitor.nextInt();
                                System.out.println("Tem certeza que deseja alterar? S/N");
                                String resposta = leitor.next();
                                if (resposta.equalsIgnoreCase("S") || resposta.equalsIgnoreCase("sim")) {
                                    a.setModelo(model);
                                    a.setCapacidade(capac);
                                    System.out.println("Aeronave alterada com sucesso! ");
                                    break;
                                }
                                break;
                            } else {
                                System.out.println("Aeronave não encontrada!");
                                break;
                            }
                        }
                        break;
                    case 3:
                        System.out.println("*********************");
                        System.out.println("Exclusão de Aeronaves");
                        System.out.println("Digite o registro da aeronave que deseja excluir");
                        int buscaAero = leitor.nextInt();
                        for (Aviao b : aviaoList) {
                            if (buscaAero == b.getRegistro()) {
                                System.out.println(b);
                                System.out.println("Tem certeza que deseja excluir? S/N");
                                String resposta = leitor.next();
                                if (resposta.equalsIgnoreCase("S") || resposta.equalsIgnoreCase("sim")) {
                                    aviaoList.remove(b);
                                    System.out.println("Aeronave excluida com sucesso! ");
                                    break;
                                } else {
                                    System.out.println("Aeronave não foi alterada");
                                }
                            } else {
                                System.out.println("Aeronave não encontrada!");
                            }
                        }
                        break;
                    case 4:
                        if (!aviaoList.isEmpty()) {
                            Collections.sort(aviaoList);
                            System.out.println(Aviao.getAviaoList());
                        } else {
                            System.out.println("Nenhuma aeronave registrada! ");
                        }
                        break;
                    case 5:
                        System.out.println("saindo...");
                        break;
                    default:
                        System.out.println("Opção inválida");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Error " + e.getMessage());
            mostraMenu();
        }
    }
}

