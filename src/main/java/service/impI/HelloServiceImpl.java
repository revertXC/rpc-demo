package service.impI;

import service.openAble.HelloServiceAble;

public class HelloServiceImpl implements HelloServiceAble {
    @Override
    public String sayHi(String name) {
        return "Hello "+name;
    }
}
