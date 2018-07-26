package assign2;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;
public class Branch {
Map<Long,Account> people=new HashMap<>();
    private static long ACC_GENERATOR=100435;
    
    public void openNewAccount(AccountType acctype,float bal,String accountHolder){
    	ACC_GENERATOR++;
    	Account t=new Account(ACC_GENERATOR,accountHolder,bal,acctype,Status.ACTIVE);
    	
    	people.put(ACC_GENERATOR,t); 	
    }
    public Account getAccount(long accno){
    	
    	System.out.println(people.get(accno).toString());
    	return people.get(accno);
    }
    public void closeAccount(long accno){
    	people.get(accno).setStatus(Status.CLOSED);
    }
    public LinkedList getALL(){
    	
    return new LinkedList<>(people.values());
    }
    public Set<Account> searchByHolderName(String accHolder){
    	return people.values().stream().filter((x)->x.getAccountHolder().equals(accHolder)).collect(Collectors.toSet());
    }
    
    
}
