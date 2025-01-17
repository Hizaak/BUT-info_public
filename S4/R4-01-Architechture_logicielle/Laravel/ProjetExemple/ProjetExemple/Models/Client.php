<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Client extends Model
{
    use HasFactory;
    protected $primaryKey='numeroclient';
    protected $fillable=['numeroclient','nom','email','cartebancaire'];
   // protected $timestamps=false;
    public function reservations()
    {return $this->hasMany('App\Reservation');}
}
