

import java.util.Scanner;

public class caixaEletronico {

	public static void main(String[] args) {

	Scanner input = new Scanner(System.in);

	int opcao, nSaques;
	String cCorrente,nomeCli,empChoice,depChoice,nomeDestinatarioTransf,cpfDestinatarioTransf,bancoDestinatarioTransf,agDestinatarioTransf,contaDestinatarioTransf;
	double saldo,saque,salario,valorEmprestado,emprestimoaPagar,credDisp,depositar,transferir;
	
	nSaques=0;
	cCorrente = "8565-0";
	nomeCli = "Danilo";
	saldo = 1000;
	saque = 0;
	salario= 5000;
	valorEmprestado=0;
	emprestimoaPagar=0;
	opcao=0;
	credDisp=salario * 2;
	depositar=0;
	transferir=0;
	
	
	while(opcao!=4) {
		
	
	System.out.println("__________________________________________________");
	System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>");
	System.out.println("<<<<<<<<<<<<<<<  CAIXA ELETR�NICO  >>>>>>>>>>>>>>>");
	System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>");
	System.out.println("__________________________________________________");
	System.out.println("                                                  ");
	System.out.println("               MENU DE OP��ES                     ");
	System.out.println("                                                  ");
	System.out.println("<<<<< 1 - Extrato >>>>>                           ");
	System.out.println("<<<<< 2 - Sacar >>>>>                             ");
	System.out.println("<<<<< 3 - Depositar >>>>>                         ");
	System.out.println("<<<<< 4 - Sair >>>>>                              ");
	System.out.println("                                                  ");
	System.out.println("Digite o n�mero da opera��o:                      ");
	
	opcao = input.nextInt();
	
	switch(opcao) {
	case 1:
		System.out.println("Op��o: " +opcao);
		System.out.println("          EXTRATO");
		System.out.println("Nome: " +nomeCli);
		System.out.println("Saldo: R$ " +saldo);
		System.out.println("Saques realizados hoje: " +nSaques);
		break;
	case 2:
		if (nSaques >= 3) {
			System.out.println("Excedido o limite de 3 saques por dia. Tente novamente amanh�!");
		}
		else {
			System.out.println("Op��o: " +opcao);
			System.out.println("          SAQUE");
			System.out.println("Digite o valor do saque: ");
			saque = input.nextDouble();
			
			if (saque>saldo) {
				System.out.println("Saldo insuficiente ==>>> " +saldo);
				System.out.println("Deseja contratar um empr�stimo com juros de 11% (S/N)? ");
				
				empChoice = input.next();
				
				if (empChoice.equals("S") || empChoice.equals("s")) 	
						{
					    System.out.println("Podemos te disponibilizar at� 2 vezes o seu sal�rio = " +salario * 2 +". Quanto gostaria de pegar emprestado? " );
					    valorEmprestado = input.nextDouble();
						
					    if ((valorEmprestado + emprestimoaPagar) <= (salario * 2))
					    	{
					   	    saldo = (saldo + valorEmprestado);
					   	    emprestimoaPagar = (emprestimoaPagar + (valorEmprestado * 1.11));
					   	    credDisp = (credDisp - emprestimoaPagar);
					   	    
					   	    System.out.println("Seu saldo ap�s pegar o empr�stimo: " +saldo);
					   	    System.out.println("Valor do empr�stimo a pagar: " +emprestimoaPagar);
					   	    
					   	    saldo = (saldo - saque);
					   	    System.out.println("Retire seu dinheiro! " +saque);
					   	    System.out.println("Seu saldo ap�s sacar o valor: " +saque + " � de: " +saldo);
					   	    //System.out.println("Voc� tem um empr�stimo pr� aprovado de : " +credDisp );
					   	    nSaques++;
					   	   
					    	}
					    else {
					    	
					    	System.out.println("Valor R$ " +valorEmprestado +" excede 2x seu sal�rio - R$ " +salario * 2 );
					    	System.out.println("Tente outro valor!");
					    }
					    	
						}
				else if (empChoice.equals("N") || empChoice.equals("n"))
				{
				System.out.println("Saldo insuficiente ==>>> " +saldo);
				}
				
				else 
				{
				System.out.println("Op��o Inv�lida!");
				}
			}
			else {
				saldo = (saldo - saque);
				System.out.println("Retire seu dinheiro!");
				System.out.println("Ap�s saque, seu saldo � de: " +saldo);
				nSaques++;
			}
			System.out.println("Saques realizados hoje: " +nSaques);
			break;
		}
		
	
	case 3:
		System.out.println("Deseja Depositar [D] ou Transferir [T]");
		depChoice = input.next();
		
		if (depChoice.equals("D") || depChoice.equals("d")) {
			
			System.out.println("Quanto deseja depositar? ");
			depositar = input.nextDouble();
			saldo = (saldo+depositar);
			System.out.println("Opera��o realizada com sucesso!");
			System.out.println("Valor depositado: " +depositar);
			System.out.println("Novo saldo ap�s dep�sito: " +saldo);
		}
		
		else if (depChoice.equals("T") || depChoice.equals("t"))
		{
			System.out.println("Preencher informa��es do destinat�rio");
			System.out.println("Nome do destinat�rio: ");
			nomeDestinatarioTransf = input.next();
			System.out.println("CPF do destinat�rio: ");
			cpfDestinatarioTransf = input.next();
			System.out.println("Banco do destinat�rio: ");
			bancoDestinatarioTransf = input.next();
			System.out.println("Ag�ncia do destinat�rio: ");
			agDestinatarioTransf = input.next();
			System.out.println("Conta do destinat�rio: ");
			contaDestinatarioTransf = input.next();
			
			System.out.println("Quanto deseja transferir? ");
			transferir = input.nextDouble();
			saldo = (saldo-transferir);
			System.out.println("Opera��o realizada com sucesso!");
			System.out.println("Valor trasnsferido: " +transferir);
			System.out.println("Novo saldo ap�s dep�sito: " +saldo);
		
		}
		
		else 
		{
		System.out.println("Op��o Inv�lida!");
		}

		


		
		break;
			
	case 4:
		System.out.println("At� logo!");
		break;
	default:
		System.out.println("Op��o inv�lida. Selecione uma as op��es abaixo");
		break;
	}
	}
	}
}
