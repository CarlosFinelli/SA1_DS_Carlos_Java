import javax.xml.crypto.Data;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Matcher;

public class Principal {
    public static void main(String[] args) throws ParseException {
        int opcao = 0;
        ArrayList<Reserva> listReserva = new ArrayList<Reserva>();
        ArrayList<Cliente> listCliente = new ArrayList<Cliente>();
        Scanner scan = new Scanner(System.in);
        InputStreamReader input = new InputStreamReader(System.in);
        while (opcao != 6) {
            System.out.println("Bem vindo ao sistema do nosso Restaurante.\n\n");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Editar Cliente");
            System.out.println("3 - Excluir Cliente");
            System.out.println("4 - Nova Reserva");
            System.out.println("5 - Lista de Reservas");
            System.out.println("6 - Sair do programa\n");
            System.out.print("Por favor, selecione uma opção: ");
            opcao = scan.nextInt();
            switch(opcao) {
                case 1:
                    Cliente cliente = new Cliente();
                    System.out.print("Por favor, insira o nome do cliente: ");
                    cliente.setNome(scan.nextLine());
                    cliente.setNome(scan.nextLine());
                    System.out.print("Por favor, insira o CPF do clinte (Favor inserir somente números): ");
                    cliente.setCPF(scan.nextLine());
                    for (Cliente c : listCliente) {
                        if (c.getCPF() == cliente.getCPF()) {
                            System.out.println("Este CPF já está cadastrado.");
                            continue;
                        }
                    }
                    System.out.print("Insira o Telefone do Cliente: ");
                    cliente.setTelefone(scan.nextLine());
                    if (listCliente.stream().count() < 1) {
                        cliente.setCodCliente(1);
                    } else {
                        Cliente c = listCliente.get(listCliente.size());
                        cliente.setCodCliente(c.getCodCliente() + 1);
                    }
                    listCliente.add(cliente);
                    continue;

                case 2:
                    for(Cliente c : listCliente) {
                        System.out.println("| Código Cliente: " + c.getCodCliente() + " | Nome: " + c.getNome() + " | " +
                                "CPF: " + c.getCPF() + " | Telefone: " + c.getTelefone() + " |");
                        System.out.println("--------------------------------------------------------------------------------");
                    }
                    System.out.print("\nPor favor, selecione o código do cliente que deseja editar: ");
                    int cod = scan.nextInt();
                    Cliente c = null;
                    for (Cliente item : listCliente) {
                        if (item.getCodCliente() == cod) {
                            c = item;
                        }
                    }
                    if (c == null) {
                        System.out.println("Código inválido.");
                        try {
                            input.read();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        continue;
                    }
                    int decisao = 0;
                    while (decisao != 2) {
                        System.out.println("1 - Nome");
                        System.out.println("2 - CPF");
                        System.out.println("3 - Telefone");
                        System.out.print("Selecione a opção que deseja alterar: ");
                        cod = scan.nextInt();
                        if (cod == 1) {
                            System.out.print("Insira o novo nome: ");
                            c.setNome(scan.nextLine());
                            c.setNome(scan.nextLine());
                            System.out.print("Deseja alterar mais alguma coisa? '1 = Sim, 2 = Não': ");
                            decisao = scan.nextInt();
                            continue;
                        }

                        if (cod == 2) {
                            System.out.print("Insira o novo CPF: ");
                            c.setCPF(scan.nextLine());
                            c.setCPF(scan.nextLine());
                            System.out.print("Deseja alterar mais alguma coisa? '1 = Sim, 2 = Não': ");
                            decisao = scan.nextInt();
                            continue;
                        }

                        if (cod == 3) {
                            System.out.print("Insira o novo Telefone: ");
                            c.setTelefone(scan.nextLine());
                            c.setTelefone(scan.nextLine());
                            System.out.print("Deseja alterar mais alguma coisa? '1 = Sim, 2 = Não': ");
                            decisao = scan.nextInt();
                            continue;
                        }
                        if (cod > 3 || cod < 1) {
                            System.out.println("Código inválido.");
                            try {
                                input.read();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            continue;
                        }
                    }
                    continue;

                case 3:
                    for(Cliente cli : listCliente) {
                        System.out.println("| Código Cliente: " + cli.getCodCliente() + " | Nome: " + cli.getNome() + " | " +
                                "CPF: " + cli.getCPF() + " | Telefone: " + cli.getTelefone() + " |");
                        System.out.println("--------------------------------------------------------------------------------");
                    }
                    System.out.print("\nPor favor, selecione o código do cliente que deseja excluir: ");
                    cod = scan.nextInt();
                    c = null;
                    for (Cliente item : listCliente) {
                        if (item.getCodCliente() == cod) {
                            c = item;
                        }
                    }
                    if (c == null) {
                        System.out.println("Código inválido.");
                        try {
                            input.read();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        continue;
                    }
                    listCliente.remove(c);
                    continue;

                case 4:
                    Reserva reserva = new Reserva();
                    System.out.print("Por favor, informe o CPF do reservista: ");
                    String cpf = scan.nextLine();
                    cpf = scan.nextLine();
                    c = null;
                    for (Cliente item : listCliente) {
                        if (Integer.parseInt(item.getCPF()) == Integer.parseInt(cpf)) {
                            reserva.setCPFREservista(cpf);
                            c = item;
                        }
                    }
                    if (c == null) {
                        System.out.println("CPF inválido.");
                        try {
                            input.read();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        continue;
                    }
                    reserva.setCPFREservista(cpf);
                    System.out.print("Insira o número de pessoas que farão parte da reserva: ");
                    reserva.setnPessoas(scan.nextInt());
                    if (reserva.getnPessoas() > 8) {
                        System.out.println("A reserva não pode ser para mais de 8 pessoas.");
                        try {
                            input.read();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        continue;
                    }
                    System.out.print("Por favor, insira o número da mesa que deseja reservar (1 a 6):");
                    reserva.listMesas.add(scan.nextInt());
                    if(reserva.getnPessoas() > 4 && reserva.getnPessoas() <= 8) {
                        System.out.print("Reserva para mais de 4 pessoas, por favor, selecione mais uma mesa " +
                                "(Mesa já selecionada: " + reserva.listMesas.get(0) + "): ");
                        reserva.listMesas.add(scan.nextInt());
                    }
                    System.out.print("Insira a data e a hora da reserva (Formato esperado 'favor incluir o espaço': DD/MM/YYYY HH:mm:ss): ");
                    String data = scan.nextLine();
                    data = scan.nextLine();
                    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.US);
                    Date date = df.parse(data);
                    df.format(date);
                    reserva.setDataReserva(date);
                    listReserva.add(reserva);
                    continue;

                case 5:
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                    c = null;
                    for (Reserva r : listReserva) {
                        for (Cliente cli : listCliente) {
                            if (Integer.parseInt(cli.getCPF()) == Integer.parseInt(r.getCPFReservista())) {
                                c = cli;
                            }

                            System.out.print("| Nome do reservista: " + c.getNome());
                            System.out.print("| CPF Reservista: " + r.getCPFReservista() + " | " +
                                    "Data e hora da Reserva: " + dateFormat.format(r.getDataReserva()) + " |\n| " +
                                    "Número de pessoas: " + r.getnPessoas() + " | Mesa(s) reservada(s): ");
                            for(int res : r.listMesas) {
                                System.out.print(res + " ");
                            }
                        }
                    }
                    try {
                        input.read();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    continue;

                case 6:
                    break;

                default:
                    System.out.println("Esta não é uma opção válida.");
                    continue;
            }
            System.out.println("Obrigado por utilizar nossos serviços.");

        }
    }
}
