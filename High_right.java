package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous
public class High_right extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor leftFrontDrive = null;
    private DcMotor leftBackDrive = null;
    private DcMotor rightFrontDrive = null;
    private DcMotor rightBackDrive = null;
    private DcMotor podnyatie1, podnyatie2;
    private Servo zahvat;

    @Override
    public void runOpMode() throws InterruptedException {

        leftFrontDrive = hardwareMap.get(DcMotor.class, "LF");
        leftBackDrive = hardwareMap.get(DcMotor.class, "LB");
        rightFrontDrive = hardwareMap.get(DcMotor.class, "RF");
        rightBackDrive = hardwareMap.get(DcMotor.class, "RB");
        podnyatie1 = hardwareMap.get(DcMotor.class, "P1");
        podnyatie2 = hardwareMap.get(DcMotor.class, "P2");
        zahvat = hardwareMap.get(Servo.class, "Z");

        leftFrontDrive.setDirection(DcMotor.Direction.REVERSE);
        leftBackDrive.setDirection(DcMotor.Direction.REVERSE);
        rightFrontDrive.setDirection(DcMotor.Direction.FORWARD);
        rightBackDrive.setDirection(DcMotor.Direction.FORWARD);

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();
        runtime.reset();

        while (opModeIsActive()) {
            zahvat.setPosition(1);
            podnyatie1.setPower(-1);
            podnyatie2.setPower(1); //Подъем
            sleep(200);

            zahvat.setPosition(1);
            rightFrontDrive.setPower(0.5);
            rightBackDrive.setPower(-0.5);
            leftBackDrive.setPower(0.5);
            leftFrontDrive.setPower(-0.5);//Влево
            sleep(800);

            rightFrontDrive.setPower(0);
            rightBackDrive.setPower(0);
            leftBackDrive.setPower(0);
            leftFrontDrive.setPower(0);
            sleep(500);

            zahvat.setPosition(1);
            podnyatie1.setPower(0);
            podnyatie2.setPower(0);
            sleep(100);

            zahvat.setPosition(1);
            rightFrontDrive.setPower(0.75);
            rightBackDrive.setPower(0.75);
            leftBackDrive.setPower(0.75);
            leftFrontDrive.setPower(0.75);//Вперед
            sleep(800);

            rightFrontDrive.setPower(0);
            rightBackDrive.setPower(0);
            leftBackDrive.setPower(0);
            leftFrontDrive.setPower(0);
            sleep(500);

            zahvat.setPosition(1);
            rightFrontDrive.setPower(0.5);
            rightBackDrive.setPower(-0.5);
            leftBackDrive.setPower(0.5);
            leftFrontDrive.setPower(-0.5);//Влево
            sleep(500);

            rightFrontDrive.setPower(0);
            rightBackDrive.setPower(0);
            leftBackDrive.setPower(0);
            leftFrontDrive.setPower(0);
            sleep(500);

            zahvat.setPosition(1);
            podnyatie1.setPower(-1);
            podnyatie2.setPower(1); //Подъем
            sleep(3200);

            zahvat.setPosition(1);
            podnyatie1.setPower(0);
            podnyatie2.setPower(0);

            zahvat.setPosition(1);
            rightFrontDrive.setPower(0.5);
            rightBackDrive.setPower(0.5);
            leftBackDrive.setPower(0.5);
            leftFrontDrive.setPower(0.5); //Вперед
            sleep(300);

            zahvat.setPosition(1);
            rightFrontDrive.setPower(0);
            rightBackDrive.setPower(0);
            leftBackDrive.setPower(0);
            leftFrontDrive.setPower(0);
            sleep(500);

            podnyatie1.setPower(1);
            podnyatie2.setPower(-1); //Опустить захват
            sleep(150);

            podnyatie1.setPower(0);
            podnyatie2.setPower(0);

            zahvat.setPosition(-1);
            sleep(10);

            zahvat.setPosition(0);
            sleep(500);

            rightFrontDrive.setPower(-0.5);
            rightBackDrive.setPower(-0.5);
            leftBackDrive.setPower(-0.5);
            leftFrontDrive.setPower(-0.5); //Назад
            sleep(400);

            rightFrontDrive.setPower(0);
            rightBackDrive.setPower(0);
            leftBackDrive.setPower(0);
            leftFrontDrive.setPower(0);
            sleep(500);

            podnyatie1.setPower(1);
            podnyatie2.setPower(-1); //Опустить захват
            sleep(1800);

            podnyatie1.setPower(0);
            podnyatie2.setPower(0);

            rightFrontDrive.setPower(-0.5);
            rightBackDrive.setPower(0.5);
            leftBackDrive.setPower(-0.5);
            leftFrontDrive.setPower(0.5); //Вправо
            sleep(600);

            rightFrontDrive.setPower(0);
            rightBackDrive.setPower(0);
            leftBackDrive.setPower(0);
            leftFrontDrive.setPower(0);

            stop();

            telemetry.addData("Status", "Run Time: " + runtime.toString());
            telemetry.update();
        }
    }
}
