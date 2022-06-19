package com.david.woods;

import java.util.List;

interface WoodsCallable
{
    int arity();
    Object call(Interpreter interpreter, List<Object> arguments);
}
