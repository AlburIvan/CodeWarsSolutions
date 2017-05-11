package com.raworkstudio.codewars.annotation;

import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

import javax.annotation.Generated;
import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.tools.JavaFileObject;
import java.io.IOException;
import java.io.Writer;
import java.util.Set;

/**
 * Created by Ivan Alburquerque on 5/10/2017.
 */
@SupportedAnnotationTypes( "com.raworkstudio.codewars.annotation.Builder" )
@SupportedSourceVersion( SourceVersion.RELEASE_8 )
//@S(Processor.class)
public class BuilderAnnotationProcessor extends AbstractProcessor {



    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {

        // process annotation

        // what we're going to build

      /*
      Person person = new PersonBuilder.Builder()
                .withName("Freddin")
                .withLastName("Alcantara")
                .withAge(21)
//                .withGender(Person.Gender.MASCULINO)
                .decideGender()
                .build();
    */

        for( final Element element: roundEnv.getElementsAnnotatedWith( Builder.class ) ) {

            if( element instanceof TypeElement ) {
                final TypeElement typeElement = (TypeElement)element;
                final PackageElement packageElement =
                        ( PackageElement )typeElement.getEnclosingElement();

                try {

                    final String className = typeElement.getSimpleName() + "Builder";
                    final JavaFileObject fileObject = processingEnv.getFiler().createSourceFile(
                            packageElement.getQualifiedName() + "." + className);

               /*     try( Writer writter = fileObject.openWriter() ) {
                        writter.append( "package " + packageElement.getQualifiedName() + ";" );
                        writter.append( "\\n\\n");
                        writter.append( "public class " + className + " {" );
                        writter.append( "\\n");
                        writter.append( "}");
                    }
*/
                    System.out.println(className);

                    // JavaPoet new class
                    MethodSpec main = MethodSpec.methodBuilder("main")
                            .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                            .returns(void.class)
                            .addParameter(String[].class, "args")
                            .addStatement("$T.out.println($S)", System.class, "Hello, JavaPoet!")
                            .build();

                    TypeSpec helloWorld = TypeSpec.classBuilder("HelloWorld")
                            .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                            .addMethod(main)
                            .build();

                    JavaFile javaFile = JavaFile.builder("com.example.helloworld", helloWorld)
                            .build();

                    javaFile.writeTo(System.out);

                } catch( IOException ex ) {
                    System.out.println(ex.getMessage());
                }
            }
        }

        return true;
    }
}
