package pl.polsl.hotel.service;

import org.springframework.stereotype.Component;
import pl.polsl.hotel.Type;
import pl.polsl.hotel.configuration.StartUpFiller;
import pl.polsl.hotel.model.*;
import pl.polsl.hotel.repository.ParameterRepository;
import pl.polsl.hotel.repository.RoomTypeRepository;

import java.util.Optional;
@Component
public class ParameterService implements StartUpFiller {
    private final ParameterRepository parameterRepository;
    private final RoomTypeRepository roomTypeRepository;
    private int numberIntIndex;
    private int numberDoubleIndex;
    private int numberStringIndex;
    private int numberBooleanIndex;
    private Type type;

    public ParameterService(ParameterRepository parameterRepository, RoomTypeRepository roomTypeRepository) {
        this.parameterRepository = parameterRepository;
        this.roomTypeRepository = roomTypeRepository;
        //int
        this.numberIntIndex = 0;
        //double
        this.numberDoubleIndex = 0;
        //string
        this.numberStringIndex = 0;
        //boolean
        this.numberBooleanIndex = 0;
    }

    public Optional<Parameter> findById(Long id) {
        return parameterRepository.findById(id);
    }

    public Parameter updateParameter(Long id, Parameter parameter) {

        parameterRepository.deleteById(id);

        return parameterRepository.save(parameter);
    }

    /*public void createColumn(Type type)
    {
        if (type == Type.INT)
        {
            if( this.columnIntIndex == 0)
                roomTypeRepository.createColumnInt();
            else if( this.columnIntIndex == 1)
            {
                roomTypeRepository.createColumnInt2();
            }
            else if( this.columnIntIndex == 2)
            {
                roomTypeRepository.createColumnInt3();
            }
            else if( this.columnIntIndex == 3)
            {
                roomTypeRepository.createColumnInt4();
            }
            else if( this.columnIntIndex == 4)
            {
                roomTypeRepository.createColumnInt5();
            }
            else if( this.columnIntIndex == 5)
            {
                roomTypeRepository.createColumnInt6();
            }   else if( this.columnIntIndex == 6)
            {
                roomTypeRepository.createColumnInt7();
            }   else if( this.columnIntIndex == 7)
            {
                roomTypeRepository.createColumnInt8();
            }   else if( this.columnIntIndex == 8)
            {
                roomTypeRepository.createColumnInt9();
            }   else if( this.columnIntIndex == 9)
            {
                roomTypeRepository.createColumnInt10();
            }   else if( this.columnIntIndex == 10)
            {
                roomTypeRepository.createColumnInt11();
            }
            else
            {
                roomTypeRepository.createColumnInt12();
            }
            this.columnIntIndex++;
        }
        else if(type == Type.DOUBLE)
        {
            if( this.columnDoubleIndex == 0)
                roomTypeRepository.createColumnDouble();
            else if( this.columnDoubleIndex == 1)
            {
                roomTypeRepository.createColumnDouble2();
            }
            else if( this.columnDoubleIndex == 2)
            {
                roomTypeRepository.createColumnDouble3();
            }
            else if( this.columnDoubleIndex == 3)
            {
                roomTypeRepository.createColumnDouble4();
            } else if( this.columnDoubleIndex == 4)
            {
                roomTypeRepository.createColumnDouble5();
            }
            else if( this.columnDoubleIndex == 5)
            {
                roomTypeRepository.createColumnDouble6();
            }
            else if( this.columnDoubleIndex == 6)
            {
                roomTypeRepository.createColumnDouble7();
            }
            else if( this.columnDoubleIndex == 7)
            {
                roomTypeRepository.createColumnDouble8();
            }
            else if( this.columnDoubleIndex == 8)
            {
                roomTypeRepository.createColumnDouble9();
            }
            else if( this.columnDoubleIndex == 9)
            {
                roomTypeRepository.createColumnDouble10();
            }
            else if( this.columnDoubleIndex == 10)
            {
                roomTypeRepository.createColumnDouble11();
            }
            else
            {
                roomTypeRepository.createColumnDouble12();
            }
            this.columnDoubleIndex++;
        }
        else if(type == Type.STRING)
        {
            if( this.columnStringIndex == 0)
                roomTypeRepository.createColumnString();
            else if( this.columnStringIndex == 1)
            {
                roomTypeRepository.createColumnString2();
            }
            else if( this.columnStringIndex == 2)
            {
                roomTypeRepository.createColumnString3();
            }
            else if( this.columnStringIndex == 3)
            {
                roomTypeRepository.createColumnString4();
            } else if( this.columnStringIndex == 4)
            {
                roomTypeRepository.createColumnString5();
            } else if( this.columnStringIndex == 5)
            {
                roomTypeRepository.createColumnString6();
            } else if( this.columnStringIndex == 6)
            {
                roomTypeRepository.createColumnString7();
            }
            else if( this.columnStringIndex == 7)
            {
                roomTypeRepository.createColumnString8();
            }
            else if( this.columnStringIndex == 8)
            {
                roomTypeRepository.createColumnString9();
            }
            else if( this.columnStringIndex == 9)
            {
                roomTypeRepository.createColumnString10();
            }
            else if( this.columnStringIndex == 10)
            {
                roomTypeRepository.createColumnString11();
            }
            else
            {
                roomTypeRepository.createColumnString12();
            }
            this.columnStringIndex++;
        }
        else
        {
            if( this.columnBooleanIndex == 0)
                roomTypeRepository.createColumnBoolean();
            else if( this.columnBooleanIndex == 1)
            {
                roomTypeRepository.createColumnBoolean2();
            }
            else if( this.columnBooleanIndex == 2)
            {
                roomTypeRepository.createColumnBoolean3();
            }
            else if( this.columnBooleanIndex == 3)
            {
                roomTypeRepository.createColumnBoolean4();
            }
            else if( this.columnBooleanIndex == 4)
            {
                roomTypeRepository.createColumnBoolean5();
            }
            else if( this.columnBooleanIndex == 5)
            {
                roomTypeRepository.createColumnBoolean6();
            }
            else if( this.columnBooleanIndex == 6)
            {
                roomTypeRepository.createColumnBoolean7();
            }
            else if( this.columnBooleanIndex == 7)
            {
                roomTypeRepository.createColumnBoolean8();
            }
            else if( this.columnBooleanIndex == 8)
            {
                roomTypeRepository.createColumnBoolean9();
            }
            else if( this.columnBooleanIndex == 9)
            {
                roomTypeRepository.createColumnBoolean10();
            }
            else if( this.columnBooleanIndex == 10)
            {
                roomTypeRepository.createColumnBoolean11();
            }
            else
            {
                roomTypeRepository.createColumnBoolean12();
            }
            this.columnBooleanIndex++;
        }
    }*/
    public Parameter save(Parameter parameter) {

        if(parameter.getTypeId() == 0)
        {
            type = Type.INT;
            parameter.setTypeNumber((long) numberIntIndex);
            numberIntIndex++;
        }

        else if(parameter.getTypeId() == 1)
        {
            type = Type.DOUBLE;
            parameter.setTypeNumber((long) numberDoubleIndex);
            numberDoubleIndex++;
        }

        else if(parameter.getTypeId() == 2)
        {
            type = Type.STRING;
            parameter.setTypeNumber((long) numberStringIndex);
            numberStringIndex++;
        }

        else
        {
            type = Type.BOOLEAN;
            parameter.setTypeNumber((long) numberBooleanIndex);
            numberBooleanIndex++;
        }

        // createColumn(type);

        return parameterRepository.save(parameter);
    }

    public void deleteParamAndColumnById(Long id, Long type, Long typeId) {

        if(type == 0)
        {
            if( typeId == 0)
                roomTypeRepository.deleteColumnInt();
            else if( typeId == 1)
            {
                roomTypeRepository.deleteColumnInt2();
            }
            else if( typeId == 2)
            {
                roomTypeRepository.deleteColumnInt3();
            }
            else if( typeId == 3)
            {
                roomTypeRepository.deleteColumnInt4();
            }
            else if( typeId == 4)
            {
                roomTypeRepository.deleteColumnInt5();
            }
            else if( typeId == 5)
            {
                roomTypeRepository.deleteColumnInt6();
            }   else if( typeId == 6)
            {
                roomTypeRepository.deleteColumnInt7();
            }   else if( typeId == 7)
            {
                roomTypeRepository.deleteColumnInt8();
            }   else if( typeId == 8)
            {
                roomTypeRepository.deleteColumnInt9();
            }   else if( typeId == 9)
            {
                roomTypeRepository.deleteColumnInt10();
            }   else if( typeId == 10)
            {
                roomTypeRepository.deleteColumnInt11();
            }
            else
            {
                roomTypeRepository.deleteColumnInt12();
            }
           // this.columnIntIndex--;
        }

        else if(type == 1)
        {
            if( typeId == 0)
                roomTypeRepository.deleteColumnDouble();
            else if( typeId == 1)
            {
                roomTypeRepository.deleteColumnDouble2();
            }
            else if( typeId == 2)
            {
                roomTypeRepository.deleteColumnDouble3();
            }
            else if( typeId == 3)
            {
                roomTypeRepository.deleteColumnDouble4();
            } else if( typeId== 4)
            {
                roomTypeRepository.deleteColumnDouble5();
            }
            else if( typeId == 5)
            {
                roomTypeRepository.deleteColumnDouble6();
            }
            else if( typeId == 6)
            {
                roomTypeRepository.deleteColumnDouble7();
            }
            else if( typeId== 7)
            {
                roomTypeRepository.deleteColumnDouble8();
            }
            else if( typeId== 8)
            {
                roomTypeRepository.deleteColumnDouble9();
            }
            else if( typeId == 9)
            {
                roomTypeRepository.deleteColumnDouble10();
            }
            else if( typeId == 10)
            {
                roomTypeRepository.deleteColumnDouble11();
            }
            else
            {
                roomTypeRepository.deleteColumnDouble12();
            }
         //   this.columnDoubleIndex--;
        }

        else if(type == 2)
        {
            if( typeId == 0)
                roomTypeRepository.deleteColumnString();
            else if( typeId == 1)
            {
                roomTypeRepository.deleteColumnString2();
            }
            else if( typeId == 2)
            {
                roomTypeRepository.deleteColumnString3();
            }
            else if( typeId == 3)
            {
                roomTypeRepository.deleteColumnString4();
            } else if( typeId== 4)
            {
                roomTypeRepository.deleteColumnString5();
            } else if( typeId == 5)
            {
                roomTypeRepository.deleteColumnString6();
            } else if( typeId == 6)
            {
                roomTypeRepository.deleteColumnString7();
            }
            else if( typeId == 7)
            {
                roomTypeRepository.deleteColumnString8();
            }
            else if( typeId == 8)
            {
                roomTypeRepository.deleteColumnString9();
            }
            else if( typeId == 9)
            {
                roomTypeRepository.deleteColumnString10();
            }
            else if( typeId == 10)
            {
                roomTypeRepository.deleteColumnString11();
            }
            else
            {
                roomTypeRepository.deleteColumnString12();
            }
         //   this.columnStringIndex--;
        }

        else
        {
            if( typeId == 0)
                roomTypeRepository.deleteColumnBoolean();
            else if( typeId == 1)
            {
                roomTypeRepository.deleteColumnBoolean2();
            }
            else if( typeId == 2)
            {
                roomTypeRepository.deleteColumnBoolean3();
            }
            else if( typeId == 3)
            {
                roomTypeRepository.deleteColumnBoolean4();
            }
            else if( typeId == 4)
            {
                roomTypeRepository.deleteColumnBoolean5();
            }
            else if( typeId == 5)
            {
                roomTypeRepository.deleteColumnBoolean6();
            }
            else if( typeId == 6)
            {
                roomTypeRepository.deleteColumnBoolean7();
            }
            else if( typeId == 7)
            {
                roomTypeRepository.deleteColumnBoolean8();
            }
            else if( typeId == 8)
            {
                roomTypeRepository.deleteColumnBoolean9();
            }
            else if( typeId == 9)
            {
                roomTypeRepository.deleteColumnBoolean10();
            }
            else if( typeId == 10)
            {
                roomTypeRepository.deleteColumnBoolean11();
            }
            else
            {
                roomTypeRepository.deleteColumnBoolean12();
            }
         //   this.columnBooleanIndex--;
        }

        parameterRepository.delete(parameterRepository.getById(id));
    }
    public void deleteById(Long id)
    {
        parameterRepository.delete(parameterRepository.getById(id));
    }

    public Iterable<Parameter> findAll() {
        return parameterRepository.findAll();
    }

    public void createInitialData() throws RuntimeException
    {
        if(parameterRepository.findAll().isEmpty())
        {
            Parameter numberOfRoomsAvailable = new Parameter();
            numberOfRoomsAvailable.setName("liczba pokoi danego typu");
            numberOfRoomsAvailable.setType("number");
            numberOfRoomsAvailable.setTypeId((long) 0);
            numberOfRoomsAvailable.setModifiable(false);
            // numberOfRoomsAvailable.setTypeNumber((long) numberIntIndex);
            // parameterRepository.save(numberOfRoomsAvailable);
            type = Type.INT;
            // createColumn(type);;
            save(numberOfRoomsAvailable);

            Parameter numberOfBeds = new Parameter();
            numberOfBeds.setName("liczba łóżek");
            numberOfBeds.setType("number");
            numberOfBeds.setTypeId((long) 0);
            numberOfBeds.setModifiable(false);
            //   numberOfBeds.setTypeNumber((long) numberIntIndex);
            //  parameterRepository.save(numberOfBeds);
            // createColumn(type);
            save(numberOfBeds);

            Parameter checkInTime = new Parameter();
            checkInTime.setName("godzina rozpoczęcia doby hotelowej");
            checkInTime.setType("number");
            checkInTime.setTypeId((long) 0);
            checkInTime.setModifiable(false);
            //  checkInTime.setTypeNumber((long) numberIntIndex);
            //   parameterRepository.save(checkInTime);
            // createColumn(type);
            save(checkInTime);

            Parameter checkOutTime = new Parameter();
            checkOutTime.setName("godzina zakończenia doby hotelowej");
            checkOutTime.setType("number");
            checkOutTime.setTypeId((long) 0);
            checkOutTime.setModifiable(false);
            //   checkOutTime.setTypeNumber((long) numberIntIndex);
            //  parameterRepository.save(checkOutTime);
           //  createColumn(type);
            save(checkOutTime);

            Parameter price = new Parameter();
            price.setName("cena");
            price.setTypeId((long) 1);
            price.setType("double");
            price.setModifiable(false);
            //  price.setTypeNumber((long) numberDoubleIndex);
            //  parameterRepository.save(price);
            type = Type.DOUBLE;
            // createColumn(type);
            save(price);
        }
        else
        {
            for (Parameter parameter: parameterRepository.findAll())
            {
                if(parameter.getTypeId() == 0)
                {
                    numberIntIndex = Math.toIntExact(parameter.getTypeNumber()) + 1;
                }
                else if(parameter.getTypeId() == 1)
                {
                    numberDoubleIndex = Math.toIntExact(parameter.getTypeNumber())  + 1;
                }
                else if(parameter.getTypeId() == 2)
                {
                    numberStringIndex = Math.toIntExact(parameter.getTypeNumber())  + 1;
                }
                else
                {
                    numberBooleanIndex = Math.toIntExact(parameter.getTypeNumber())  + 1;
                }
            }
        }
    }


}
