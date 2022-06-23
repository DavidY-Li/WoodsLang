package com.david.woods;

import java.util.List;
import java.util.Map;

class WoodsClass implements WoodsCallable
{
    final String name;
    final WoodsClass superclass;
    private final Map<String, WoodsFunction> methods;

    WoodsClass(String name, WoodsClass superclass, Map<String, WoodsFunction> methods)
    {
        this.superclass = superclass;
        this.name = name;
        this.methods = methods;
    }

    WoodsFunction findMethod(String name)
    {
        if (methods.containsKey(name))
        {
            return methods.get(name);
        }

        if (superclass != null)
        {
            return superclass.findMethod(name);
        }

        return null;
    }

    @Override
    public String toString()
    {
        return name;
    }

    @Override
    public Object call(Interpreter interpreter, List<Object> arguments)
    {
        WoodsInstance instance = new WoodsInstance(this);
        WoodsFunction initializer = findMethod("init");

        if (initializer != null)
        {
            initializer.bind(instance).call(interpreter, arguments);
        }

        return instance;
    }

    @Override
    public int arity()
    {
        WoodsFunction initializer = findMethod("init");
        if (initializer == null) return 0;
        return initializer.arity();
    }
}