import java.util.ArrayList;
import java.util.List;

public class ListSolverSuicide implements SuicideSolverInterface {

  @Override
  public int solve(int numberOfPeople, int startingPoint, int numberToBeSkipped) {
    List<Integer> people = addPeople(numberOfPeople);

    return removePeople(startingPoint  , numberToBeSkipped ,people);
  }

  public  List<Integer> addPeople(int people){
    List<Integer> list = new ArrayList<>();
    int i = 0;
    while(i < people){
      list.add(i);
      i++;
    }
    return list;
  }

  public int removePeople(int start, int numberToSkip, List<Integer> people){
    int size = people.size();
    if(size == 1) {
      return people.get(0);
    }
    int removeNum = (((numberToSkip % size) + (start)) % size);
    if(removeNum != 0){
      removeNum--;
    }else{
      removeNum = size - 1;
    }
    people.remove(removeNum);

    return removePeople(removeNum ,numberToSkip, people);

  }

}
