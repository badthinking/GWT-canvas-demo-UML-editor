package org.twbbs.peak.uml.manage.object;

import java.util.List;

import org.twbbs.peak.uml.core.UMLCore;
import org.twbbs.peak.uml.object.UMLObject;
import org.twbbs.peak.uml.object.basic.UMLBasicObject;
import org.twbbs.peak.uml.object.composite.GroupObject;
import org.twbbs.peak.uml.util.Point;

public class UMLObjectManagerImpl implements UMLObjectManager{
    private UMLCore umlCore;
    private LineHandler lineHandler;
    private ObjectHandler objectHandler;
    private GroupHandler groupHandler;
    public UMLObjectManagerImpl(UMLCore core) {
        this.umlCore=core;
        this.lineHandler=new LineHandler();
        this.objectHandler=new ObjectHandler(umlCore);
        this.groupHandler=new GroupHandler(core);
    }
    
    public void createClassObject(int x, int y) {
        objectHandler.createClassObject(x, y);
    }

    public void createUseCaseObject(int x, int y) {
        objectHandler.createUseCaseObject(x, y);
    }
    public UMLObject getUMLObject(int x, int y) {
        return objectHandler.getUMLObject(x, y);
    }
    public UMLBasicObject getUMLBasicObject(int x, int y) {
        return objectHandler.getUMLBasicObject(x, y);
    }
    public void update() {
        umlCore.update();
    }
    public List<UMLObject> getAllObjects() {
        return objectHandler.getAllObjects();
    }
    public void group(List<UMLObject> list) {
        groupHandler.group(list);
    }
    public void unGroup(GroupObject object) {
        groupHandler.unGroup(object);
    }

    public void associateObjects(Point prePoint, UMLBasicObject objectA,
            Point postPoint, UMLBasicObject objectB) {
        lineHandler.associateObjects(prePoint, objectA, postPoint, objectB);
        update();
    }

    public void compositeObjects(Point prePoint, UMLBasicObject objectA,
            Point postPoint, UMLBasicObject objectB) {
        lineHandler.compositeObjects(prePoint, objectA, postPoint, objectB);
        update();
    }

    public void generalizeObjects(Point prePoint, UMLBasicObject objectA,
            Point postPoint, UMLBasicObject objectB) {
        lineHandler.generalizeObjects(prePoint, objectA, postPoint, objectB);
        update();
    }
}
