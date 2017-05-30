import java.util.List;
import java.util.Scanner;
import java.time.LocalTime;
import java.util.ArrayList;

public class Main {

    private static int opcao;
    private static String login;
    private static String senha;
    private static boolean perfil; // perfil == true é adminstrador

    private static Venda venda = new Venda();
    private static List<Venda> listaVendas = new ArrayList<>(); // contem os dados de cada venda reliazada
    private static List<Produto> listProdutosVendidos = new ArrayList<>(); // contem o produtos vendidos
    private static Estoque estoque = new Estoque();
    private static List<Produto> listaEntraEstoque = new ArrayList<>(); // contem o que entrou no estoque
    private static List<Usuario> usuarios = new ArrayList<>();
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        listaEntraEstoque.add(new Produto("Macarrão", "F. Fortaleza", 1234, 100, 2.8, 2.0, new Date(10, 10, 2017)));
        listaEntraEstoque.add(new Produto("Macarrão", "F. Fortaleza", 1234, 100, 2.8, 2.0, new Date(10, 10, 2017)));

//        listProdutosVendidos.add(new Produto("Maca", "F. Fortaleza", 1234, 100, 2.8, 2.0, new Date(10,10,2017),new Date(10,10,2017)));

        usuarios.add(new Usuario("Weslley", "1234", true));
        usuarios.add(new Usuario("Joao", "1235", true));
        usuarios.add(new Usuario("Felipe", "1236", false));
        usuarios.add(new Usuario("Maira", "1237", false));

        do {

            boolean login = login();

            /** Se for admin*/
            if (login) {

                System.out.println("\nBem Vindo Administrador!");
                do {
                    System.out.println("#1 Usuário");
                    System.out.println("#2 Estoque");
                    System.out.println("#3 Logout");
                    System.out.print("Escolha: ");
                    opcao = Integer.parseInt(input.nextLine());

                    /** Menu Adminstrador */
                    switch (opcao) {

                        /** Menu usuário*/
                        case 1: {

                            do {
                                System.out.println("\n#1 Cadastrar Usuário");
                                System.out.println("#2 Editar Usuário");
                                System.out.println("#3 Remover Usuário");
                                System.out.println("#4 Exit");
                                System.out.print("Escolha: ");
                                opcao = Integer.parseInt(input.nextLine());

                                /** Usuário: add, edit, remove*/
                                switch (opcao) {

                                    /** Cadastrar Usuário*/
                                    case 1: {
                                        cadastrarUsuario();
                                        break;
                                    }

                                    /** Editar Usuário*/
                                    case 2: {
                                        editUsuario();
                                        break;
                                    }

                                    /** Remover Usuário*/
                                    case 3: {
                                        removeUsuario();
                                        break;
                                    }
                                }
                            } while (opcao != 4);

                            break;
                        }
                        /** Menu Estoque*/
                        case 2: {
                            do {
                                System.out.println("\n#1 Cadastrar Produto");
                                System.out.println("#2 Editar Produto");
                                System.out.println("#3 Remover Produto:");
                                System.out.println("#4 Exit");
                                System.out.print("Escolha: ");
                                opcao = Integer.parseInt(input.nextLine());

                                /** Produto: add, edit, remove*/
                                switch (opcao) {

                                    /** Cadastrar Produto*/
                                    case 1: {
                                        cadastrarProduto();
                                        break;
                                    }

                                    /** Editar Produto*/
                                    case 2: {
                                        editaEstoque();
                                        break;
                                    }

                                    /** Remover Produto*/
                                    case 3: {
                                        removeProduto();
                                        break;
                                    }
                                }
                            } while (opcao != 4);
                            break;
                        }
                    }
                    System.out.println();
                } while (opcao != 3);
            }

            /** Menu Vendedor: Se for Vendedor*/
            else {
                do {


                    System.out.println("\nBem Vindo Vendedor");

                    System.out.println("#1 Vender");
                    System.out.println("#2 Emitir Relátorios");
                    System.out.println("#3 Exit");
                    System.out.print("Escolha: ");
                    opcao = Integer.parseInt(input.nextLine());

                    switch (opcao) {
                        case 1: {
                            venda();
                            break;
                        }
                        case 2: {
                            System.out.println("\n======== Relatórios ===========");
                            System.out.print("\nDigite mês do relátorio: ");
                            int mes = Integer.parseInt(input.nextLine());
                            do {
                                System.out.println("Escolhar Relatório");
                                System.out.println("#1 Entrada Estoque");
                                System.out.println("#2 Saída Estoque");
                                System.out.println("#3 Relátório Vendas");
                                System.out.println("#4 Exit");
                                System.out.print("Escolha: ");
                                opcao = Integer.parseInt(input.nextLine());

                                switch (opcao) {

                                    /** Relátorio entrada no estoque*/
                                    case 1: {
                                        realatorioEntradaEstoque(mes);
                                        break;
                                    }
                                    case 2: {
                                        relatorioVendas(mes);
                                        break;
                                    }
                                    case 3: {
                                        realatorioEntradaEstoque(mes);
                                        relatorioVendas(mes);
                                        break;
                                    }
                                }
                            } while(opcao != 4);
                            break;
                        }
                    }
                } while (opcao != 3);
            }

        } while (true);


    }

    private static boolean login() {

        boolean isLogin = false; // termina se login é valido
        boolean perfil = false; // termina se é Adminstrador ou Vendedor

        System.out.println("=====LOGIN!=====");

        /** Loop até que seja digitado usuário válido*/
        do {

            System.out.print("Login: ");
            login = input.nextLine();

            for (Usuario usuario : usuarios) {

                if (usuario.getLogin().equals(login)) {

                    /** Se login for valido */
                    isLogin = true;

                    /** Loop até que seja digitado senha válida*/
                    do {
                        System.out.print("Senha: ");
                        senha = input.nextLine();

                        /** Senha errada */
                        if (!usuario.getSenha().equals(senha))
                            System.out.println("Senha Invalida!");

                    } while (!usuario.getSenha().equals(senha));

                    /** Retorna true se admistrador, false se vendedor*/
                    if (usuario.isPerfil())
                        perfil = true;
                    break;
                }
            }

            /** Se login for invalido*/
            if (!isLogin)
                System.out.println("Login invalido!");
        } while (!isLogin);

        System.out.println("Login Realizado com sucesso...");

        /** Retorna se adminstrador ou Vendedor*/
        return perfil;
    }

    private static void cadastrarUsuario() {

        impremeUsuários();

        do {
            System.out.println("\n=====Escolha o Perfil======");
            System.out.println("#1 Vendedor");
            System.out.println("#2 Administrador");
            System.out.print("Digite: ");
            opcao = Integer.parseInt(input.nextLine());

            /** Configura se o usuário é admin ou vendedor*/
            if (opcao == 1) {
                perfil = false;
            } else if (opcao == 2) {
                perfil = true;
            } else
                System.out.println("Entrada Invalida!");

        } while (opcao < 1 || opcao > 2);

        System.out.print("Escolha um login: ");
        login = input.nextLine();
        System.out.print("Escolha a Senha: ");
        senha = input.nextLine();

        Usuario usuario = new Usuario(login, senha, perfil);
        usuarios.add(usuario);
        System.out.println("Usuário Cadastrado com Sucesso...\n");

        impremeUsuários();
    }

    private static void removeUsuario() {

        impremeUsuários();

        System.out.print("\nDigite o Login do Usuário a ser Execluido: ");
        String login = input.nextLine();

        int usuariosCount = usuarios.size();

        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getLogin().equals(login))
                usuarios.remove(usuarios.get(i));
        }

        if (usuarios.size() == usuariosCount)
            System.out.println("Usuário Ivalido!");
        else
            System.out.println("Usuário Removido...");
        System.out.println();
        impremeUsuários();
    }

    private static void editUsuario() {


        impremeUsuários();


        do {

            System.out.println("#1 - Login");
            System.out.println("#2 - Senha");
            System.out.println("#3 - Permissão");
            System.out.println("#4 - Exit");
            System.out.print("Digite: ");
            opcao = Integer.parseInt(input.nextLine());

            switch (opcao) {
                case 1: {

                    System.out.print("\nDigite o Nome do Usuário que Deseja Alterar: ");
                    String login = input.nextLine();

                    for (int i = 0; i < usuarios.size(); i++) {

                        if (usuarios.get(i).getLogin().equals(login)) {

                            System.out.print("Digite Novo Login: ");
                            String novoLogin = input.nextLine();

                            usuarios.get(i).setLogin(novoLogin);
                            System.out.println("Login alterado com sucesso...");
                            impremeUsuários();
                        }
                    }

                    break;
                }
                case 2: {

                    System.out.print("\nDigite o Nome do Usuário que Deseja Alterar: ");
                    String login = input.nextLine();


                    for (int i = 0; i < usuarios.size(); i++) {

                        if (usuarios.get(i).getLogin().equals(login)) {

                            System.out.print("Digite Nova Senha: ");
                            String novaSenha = input.nextLine();

                            usuarios.get(i).setSenha(novaSenha);

                            System.out.println("Senha Alterado com sucesso...");
                            impremeUsuários();
                        }
                    }

                    break;
                }
                case 3: {

                    System.out.print("\nDigite o Nome do Usuário que Deseja Alterar: ");
                    String login = input.nextLine();

                    for (int i = 0; i < usuarios.size(); i++) {
                        if (usuarios.get(i).getLogin().equals(login)) {

                            System.out.print("\nA - Admin\nV - Vendedor\n");
                            System.out.print("Digite Nova Permissão: ");
                            String novaPermissao = input.nextLine();

                            if (novaPermissao.equalsIgnoreCase("A"))
                                usuarios.get(i).setPerfil(true);
                            else if (novaPermissao.equalsIgnoreCase("V"))
                                usuarios.get(i).setPerfil(false);

                            impremeUsuários();
                        }
                    }

                    break;
                }
            }

        } while (opcao != 4);

    }

    private static void impremeUsuários() {
        System.out.printf("\n====== Lista de Usuários Cadastrados =======");

        for (int i = 0; i < usuarios.size(); i++) {
            System.out.printf("%nLogin: %s - ", usuarios.get(i).getLogin());
            if (usuarios.get(i).isPerfil() == true)
                System.out.print("Admin");
            else
                System.out.print("Vendedor");
        }
        System.out.println("\n============================================");
    }

    private static void cadastrarProduto() {

        System.out.print("\nDigite Nome: ");
        String nome = input.nextLine();

        System.out.print("Digite Fabricante: ");
        String fabricante = input.nextLine();

        System.out.print("Digite Codigo: ");
        int codigo = Integer.parseInt(input.nextLine());

        System.out.print("Digite Quantidade: ");
        int quantidade = Integer.parseInt(input.nextLine());

        System.out.print("Digite Custo: ");
        double custo = Double.parseDouble(input.nextLine());

        System.out.print("Digite Preço Venda: ");
        double preco = Double.parseDouble(input.nextLine());

        System.out.print("Digite dia do cadastro: ");
        int dia = Integer.parseInt(input.nextLine());

        System.out.print("Digite mês do cadastro: ");
        int mes = Integer.parseInt(input.nextLine());

        System.out.print("Digite ano do cadastro: ");
        int ano = Integer.parseInt(input.nextLine());

        estoque.listaProdutos.add(new Produto(nome, fabricante, codigo, quantidade, preco, custo, new Date(dia, mes, ano)));
        listaEntraEstoque.add(new Produto(nome, fabricante, codigo, quantidade, preco, custo, new Date(dia, mes, ano)));

        System.out.println(estoque);

    }

    private static void removeProduto() {

        System.out.println();
        System.out.println(estoque);

        System.out.print("\nDigite Codigo Produto a ser Excluido: ");
        int codigo = Integer.parseInt(input.nextLine());

        int estoqueCount = estoque.listaProdutos.size();

        for (int i = 0; i < estoque.listaProdutos.size(); i++) {
            if (estoque.listaProdutos.get(i).getCodigo() == codigo)
                estoque.listaProdutos.remove(estoque.listaProdutos.get(i));
        }

        if (estoque.listaProdutos.size() == estoqueCount)
            System.out.println("Código Produto Inválido!");
        else
            System.out.println("Produto Removido...");

        System.out.println();
        System.out.println(estoque);
    }

    private static void editaEstoque() {

        System.out.println(estoque);

        System.out.print("\nDigite o Código do Produto que Deseja Alterar: ");
        int codigo = Integer.parseInt(input.nextLine());

        do {
            System.out.println("#1 - Nome");
            System.out.println("#2 - Fabricante");
            System.out.println("#3 - Codigo");
            System.out.println("#4 - Quantidade");
            System.out.println("#5 - Preço");
            System.out.println("#6 - Exit");
            System.out.print("Digite: ");
            opcao = Integer.parseInt(input.nextLine());

            switch (opcao) {
                case 1: {
                    for (int i = 0; i < estoque.listaProdutos.size(); i++) {
                        if (estoque.listaProdutos.get(i).getCodigo() == codigo) {
                            System.out.print("Digite Novo Nome: ");
                            estoque.listaProdutos.get(i).setNome(input.nextLine());
                            System.out.println(estoque);
                            break;
                        }
                    }
                    break;
                }

                case 2: {
                    for (int i = 0; i < estoque.listaProdutos.size(); i++) {
                        if (estoque.listaProdutos.get(i).getCodigo() == codigo) {
                            System.out.print("Digite Novo Fabricante: ");
                            estoque.listaProdutos.get(i).setFabricante(input.nextLine());
                            System.out.println(estoque);

                        }
                    }
                    break;
                }

                case 3: {
                    for (int i = 0; i < estoque.listaProdutos.size(); i++) {
                        if (estoque.listaProdutos.get(i).getCodigo() == codigo) {
                            System.out.print("Digite Novo Codigo: ");
                            estoque.listaProdutos.get(i).setCodigo(Integer.parseInt(input.nextLine()));
                            System.out.println(estoque);

                        }
                    }
                    break;
                }

                case 4: {
                    for (int i = 0; i < estoque.listaProdutos.size(); i++) {
                        if (estoque.listaProdutos.get(i).getCodigo() == codigo) {
                            System.out.print("Digite Novo Quantidade: ");
                            estoque.listaProdutos.get(i).setQuantidade(Integer.parseInt(input.nextLine()));
                            System.out.println(estoque);

                        }
                    }
                    break;
                }

                case 5: {
                    for (int i = 0; i < estoque.listaProdutos.size(); i++) {
                        if (estoque.listaProdutos.get(i).getCodigo() == codigo) {
                            System.out.print("Digite Novo Preço: ");
                            estoque.listaProdutos.get(i).setCusto(Double.parseDouble(input.nextLine()));
                            System.out.println(estoque);

                        }
                    }
                    break;
                }
            }
        } while (opcao != 6);
        System.out.println();
        System.out.println(estoque);
    }

    private static void venda() {
        System.out.println(estoque);

        System.out.print("\nDigite Código: ");
        int codigo = Integer.parseInt(input.nextLine());
        System.out.print("Digite Quantidade: ");
        int quatidade = Integer.parseInt(input.nextLine());

        /** Percorre o estoque procurando o produto a ser vendido*/
        for (int i = 0; i < estoque.listaProdutos.size(); i++) {

            /** Verifica se achou o produto a ser vendido*/
            if (estoque.listaProdutos.get(i).getCodigo() == codigo) {

                boolean isvenda = true;

                do {

                    /** Verifica se a quantidade no estoque é maior que quantidade a ser vendida*/
                    if (estoque.listaProdutos.get(i).getQuantidade() > quatidade) {

                        Produto produtocopy = new Produto();

                        produtocopy.setNome(estoque.listaProdutos.get(i).getNome());
                        produtocopy.setFabricante(estoque.listaProdutos.get(i).getFabricante());
                        produtocopy.setQuantidade(estoque.listaProdutos.get(i).getQuantidade());
                        produtocopy.setPrecoVenda(estoque.listaProdutos.get(i).getPrecoVenda());
                        produtocopy.setCusto(estoque.listaProdutos.get(i).getCusto());
                        produtocopy.setCodigo(estoque.listaProdutos.get(i).getCodigo());
                        produtocopy.setDataEntradaEstoque(estoque.listaProdutos.get(i).getDataEntradaEstoque());

                        /** Adicionar listaProdutosVendidos o produto vendido*/
                        listProdutosVendidos.add(produtocopy);

                        /** Adiciona uma venda no ArrayList de listaVendas*/
                        listaVendas.add(new Venda());

                        /** Configra a quantidade vendida do produto*/
                        listProdutosVendidos.get(venda.getIndexListVendaCount()).setQuantidade(quatidade);

                        System.out.print("Digite dia da venda: ");
                        int dia = Integer.parseInt(input.nextLine());

                        System.out.print("Digite mês da venda: ");
                        int mes = Integer.parseInt(input.nextLine());

                        System.out.print("Digite ano da venda: ");
                        int ano = Integer.parseInt(input.nextLine());

                        /** Adiciona data da venda na lista de vendas*/
                        listaVendas.get(venda.getIndexListVendaCount()).setDataVenda(new Date(dia, mes, ano));

                        /** Adiciona data da venda na no protuto vendido que está na listaProdutosVendidos*/
                        listProdutosVendidos.get(venda.getIndexListVendaCount()).setDataVenda(new Date(dia, mes, ano));

                        /** Configurando o valor da venda multiplicando o preço do produto da venda pela quantidade vendida*/
                        listaVendas.get(venda.getIndexListVendaCount()).setValor(
                                listProdutosVendidos.get(venda.getIndexListVendaCount()).getPrecoVenda() *
                                        listProdutosVendidos.get(venda.getIndexListVendaCount()).getQuantidade());

                        System.out.print("Digite um código para venda: ");
                        /** Configura código da venda*/
                        listaVendas.get(venda.getIndexListVendaCount()).setCodigoVenda(Integer.parseInt(input.nextLine()));

                        /** Pega a hora local*/
                        LocalTime vendaHora = LocalTime.now();

                        /** Configura hora da venda*/
                        listaVendas.get(venda.getIndexListVendaCount()).setHora(
                                vendaHora.getHour() + ":" + vendaHora.getMinute() + ":" + vendaHora.getSecond());

                        venda.incrementaIndexListVendaCount();

                        /** Retira do estoque a quantidade vendida do produto*/
                        estoque.listaProdutos.get(i).setQuantidade(estoque.listaProdutos.get(i).getQuantidade() - quatidade);

                        isvenda = false;

                        /** Verifica se a quantidade no estoque é igual a quantidade a ser vendida*/
                    } else if (estoque.listaProdutos.get(i).getQuantidade() == quatidade) {

                        Produto produtocopy = new Produto();

                        produtocopy.setNome(estoque.listaProdutos.get(i).getNome());
                        produtocopy.setFabricante(estoque.listaProdutos.get(i).getFabricante());
                        produtocopy.setQuantidade(estoque.listaProdutos.get(i).getQuantidade());
                        produtocopy.setPrecoVenda(estoque.listaProdutos.get(i).getPrecoVenda());
                        produtocopy.setCusto(estoque.listaProdutos.get(i).getCusto());
                        produtocopy.setCodigo(estoque.listaProdutos.get(i).getCodigo());
                        produtocopy.setDataEntradaEstoque(estoque.listaProdutos.get(i).getDataEntradaEstoque());

                        /** Adiciona o produto vendido a lista de listaVendas*/
                        listProdutosVendidos.add(produtocopy);

                        /** Adiciona uma venda no ArrayList de listaVendas*/
                        listaVendas.add(new Venda());

                        System.out.print("Digite dia da venda: ");
                        int dia = Integer.parseInt(input.nextLine());

                        System.out.print("Digite mês da venda: ");
                        int mes = Integer.parseInt(input.nextLine());

                        System.out.print("Digite ano da venda: ");
                        int ano = Integer.parseInt(input.nextLine());

                        /** Adiciona data a venda*/
                        listaVendas.get(venda.getIndexListVendaCount()).setDataVenda(new Date(dia, mes, ano));

                        /** Adiciona data da venda na no protuto vendido que está na listaProdutosVendidos*/
                        listProdutosVendidos.get(venda.getIndexListVendaCount()).setDataVenda(new Date(dia, mes, ano));

                        /** Configurando o valor da venda multiplicando o preço do produto da venda pela quantidade vendida*/
                        listaVendas.get(venda.getIndexListVendaCount()).setValor(
                                listProdutosVendidos.get(venda.getIndexListVendaCount()).getPrecoVenda() *
                                        listProdutosVendidos.get(venda.getIndexListVendaCount()).getQuantidade());

                        System.out.print("Digite um código para venda: ");
                        venda.setCodigoVenda(Integer.parseInt(input.nextLine()));

                        /** Pega a hora local*/
                        LocalTime vendaHora = LocalTime.now();

                        /** Configura hora da venda*/
                        listaVendas.get(venda.getIndexListVendaCount()).setHora(
                                vendaHora.getHour() + ":" + vendaHora.getMinute() + ":" + vendaHora.getSecond());

                        venda.incrementaIndexListVendaCount();

                        /** Retira do estoque produto vendido*/
                        estoque.listaProdutos.remove(estoque.listaProdutos.get(i));

                        isvenda = false;

                    } else {
                        System.out.println("Estoque menor que quantidade vendida!\n");

                        System.out.print("Digite Quantidade: ");
                        quatidade = Integer.parseInt(input.nextLine());

                    }
                } while (isvenda);
            }
        }
        System.out.println("Venda realizada com sucesso...");
        System.out.println();
        System.out.println(estoque);

        System.out.print("\n====================================== Dados Venda =========================================");
        imprimeVendas();
        System.out.println("\n============================================================================================");
        System.out.println();
    }

    private static void imprimeVendas() {
        for (int i = 0; i < listProdutosVendidos.size(); i++)
            System.out.printf("\n%s%s, Data Venda: [%s]", listProdutosVendidos.get(i), listaVendas.get(i), listaVendas.get(i).getDataVenda());
    }

    private static void relatorioVendas(int mes) {


        boolean isRelatorio = false;
        double totalVendido = 0;

        System.out.println("===================================== Relatório de Vendas ===============================");

        for (int i = 0; i < listProdutosVendidos.size(); i++) {
            if (listProdutosVendidos.get(i).getDataVenda().getMes() == mes) {
                System.out.printf("\n%s, Código Venda: [%s]", listProdutosVendidos.get(i), listProdutosVendidos.get(i).getDataVenda().toString());
                totalVendido += listProdutosVendidos.get(i).getPrecoVenda() * listProdutosVendidos.get(i).getQuantidade();
                isRelatorio = true;
            }
        }
        if (isRelatorio) {
            System.out.printf("\nTotal Vendido: R$ %.2f", totalVendido);
            System.out.println("\n============================================================");
        }

    }

    private static void realatorioEntradaEstoque(int mes) {

        boolean isRelatorio = false;
        double investimeEstoque = 0;

        System.out.print("================== Relátorio Entrada Estoque ===================");
        /** Percorre a lista de produtos que entraram no estoque para achar os que entraram no mês*/
        for (int i = 0; i < listaEntraEstoque.size(); i++) {

            if (listaEntraEstoque.get(i).getDataEntradaEstoque().getMes() == mes) {
                System.out.printf("\n%s", listaEntraEstoque.get(i));
                investimeEstoque += listaEntraEstoque.get(i).getQuantidade() *
                        listaEntraEstoque.get(i).getCusto();
                isRelatorio = true;
            }
        }
        if (isRelatorio) {
            System.out.printf("\nInvestimento em Produtos: R$ %.2f", investimeEstoque);
            System.out.println("\n================================================================");
        }
    }

}