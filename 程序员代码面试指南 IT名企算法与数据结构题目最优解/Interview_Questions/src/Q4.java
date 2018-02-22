//设计一个猫狗队列满足：
//add方法将猫或狗加入队列
//polAll按进入队列的先后顺序弹出一个实例
//pollDog pollCat 按先后顺序弹出一个猫或者狗
//isEmpty isDogEmpty isCatEmpty 分别判断队列中是否还有实例、狗实例或猫实例
import java.util.LinkedList;
import java.util.Queue;

class Pet{
    private String type;
    public Pet(String type){
        this.type=type;
    }
    public String getPetType(){
        return this.type;
    }
}

class Dog extends Pet{
    public Dog(){
        super("dog");
    }
}
class Cat extends Pet{
    public Cat(){
        super("cat");
    }
}

class petQueue{
    private Pet pet;
    private long count;
    public petQueue(Pet pet, long count){
        this.pet=pet;
        this.count=count;
    }
    public Pet getpetQueue(){
        return this.pet;
    }
    public long getCount(){
        return this.count;
    }
    public String getpetQueueType(){
        return this.pet.getPetType();
    }
}

class DogCatQueue{
    private Queue<petQueue> dog;
    private Queue<petQueue> cat;
    private long count;

    DogCatQueue(){
        this.dog=new LinkedList<petQueue>();
        this.cat=new LinkedList<petQueue>();
        this.count=0;
    }

    public void add(Pet pet){
        if(pet.getPetType().equals("dog")){
            this.dog.add(new petQueue(pet,count++));
        }else{
            this.cat.add(new petQueue(pet,count++));
        }
    }

    public Pet pollAll(){
        if(!this.dog.isEmpty()&&!this.cat.isEmpty()){
            if(this.dog.isEmpty()){
                return this.cat.poll().getpetQueue();
            }
            if(this.cat.isEmpty()){
                return this.dog.poll().getpetQueue();
            }
            if(this.dog.peek().getCount()>this.cat.peek().getCount()){
                return this.dog.poll().getpetQueue();
            }else{
                return this.cat.poll().getpetQueue();
            }
        }else{
            throw new RuntimeException("Empty");
        }
    }
    public Dog pollDog(){
        if(!this.dog.isEmpty()){
            return (Dog) this.dog.poll().getpetQueue();
        }else{
            throw new RuntimeException("Empty");
        }
    }
    public Cat pollCat(){
        if(!this.cat.isEmpty()){
            return (Cat) this.cat.poll().getpetQueue();
        }else{
            throw new RuntimeException("Empty");
        }
    }

    public boolean isEmpty(){
        if(!this.cat.isEmpty()||!this.dog.isEmpty()){
            return true;
        }else{
            return false;
        }
    }

    public boolean isDogEmpty(){
        if(!this.dog.isEmpty()){
            return true;
        }else{
            return false;
        }
    }

    public boolean isCatEmpty(){
        if(!this.cat.isEmpty()){
            return true;
        }else{
            return false;
        }
    }

}

public class Q4 {
    public static void main(String[] args) {
    }

}
